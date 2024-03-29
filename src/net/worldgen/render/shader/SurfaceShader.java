package net.worldgen.render.shader;

import net.worldgen.object.Camera;
import net.worldgen.object.DirectionLight;
import net.worldgen.object.planet.PlanetData;
import net.worldgen.util.Maths;
import net.worldgen.util.vector.Matrix4f;

public class SurfaceShader extends ShaderProgram {

	private static final String VERTEX_PATH = "/shader/surface.vsh.txt";
	private static final String FRAGMENT_PATH = "/shader/surface.fsh.txt";
	
	private int location_transformationMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;
	private int location_dirLightDir;
	private int location_dirLightColor;
	private int location_dirLightIntensity;
	private int location_lod;
	private int location_radius;
	private int location_amplitude;
	private int location_offset;
	private int location_octaves;
	private int location_freq;
	private int location_normalDetail;
	private int location_color1;
	private int location_color2;
	private int location_color3;
	private int location_color4;
	
	public SurfaceShader() {
		super(VERTEX_PATH, FRAGMENT_PATH);
	}

	@Override
	protected void bindAttributes() {
		super.bindAttribute(0, "vertex");
	}
	
	@Override
	protected void getUniformLocations() {
		location_transformationMatrix = super.getUniformLocation("transformationMatrix");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix = super.getUniformLocation("viewMatrix");
		location_dirLightDir = super.getUniformLocation("dirLightDir");
		location_dirLightColor = super.getUniformLocation("dirLightColor");
		location_dirLightIntensity = super.getUniformLocation("dirLightIntensity");
		location_lod = super.getUniformLocation("lod");
		location_radius = super.getUniformLocation("radius");
		location_amplitude = super.getUniformLocation("amplitude");
		location_offset = super.getUniformLocation("offset");
		location_octaves = super.getUniformLocation("octaves");
		location_freq = super.getUniformLocation("freq");
		location_normalDetail = super.getUniformLocation("normalDetail");
		location_color1 = super.getUniformLocation("color1");
		location_color2 = super.getUniformLocation("color2");
		location_color3 = super.getUniformLocation("color3");
		location_color4 = super.getUniformLocation("color4");
	}
	
	public void loadTransformationMatrix(Matrix4f matrix) {
		super.loadMatrix(location_transformationMatrix, matrix);
	}
	
	public void loadViewMatrix(Camera camera) {
		Matrix4f viewMatrix = Maths.createViewMatrix(camera);
		super.loadMatrix(location_viewMatrix, viewMatrix);
	}
	
	public void loadProjectionMatrix(Matrix4f projection) {
		super.loadMatrix(location_projectionMatrix, projection);
	}

	public void loadDirLight(DirectionLight light) {
		super.loadVector(location_dirLightDir, light.getDirection());
		super.loadVector(location_dirLightColor, light.getColor());
		super.loadFloat(location_dirLightIntensity, light.getIntensity());
	}
	
	public void loadLod(int lod) {
		super.loadInt(location_lod, lod);
	}
	
	public void loadRadius(float radius) {
		super.loadFloat(location_radius, radius);
	}
	
	public void loadPlanetData(PlanetData data) {
		super.loadFloat(location_amplitude, data.getAmplitude());
		super.loadFloat(location_offset, data.getOffset());
		super.loadInt(location_octaves, data.getOctaves());
		super.loadFloat(location_freq, data.getFreq());
		super.loadFloat(location_normalDetail, data.getNormalDetail());
		super.loadVector(location_color1, data.getColor1());
		super.loadVector(location_color2, data.getColor2());
		super.loadVector(location_color3, data.getColor3());
		super.loadVector(location_color4, data.getColor4());
	}
	
}
