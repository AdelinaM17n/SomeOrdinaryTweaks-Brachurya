import io.github.coolcrabs.brachyura.dependency.JavaJarDependency;
import io.github.coolcrabs.brachyura.fabric.FabricLoader;
import io.github.coolcrabs.brachyura.fabric.FabricMaven;
import io.github.coolcrabs.brachyura.fabric.FabricProject;
import io.github.coolcrabs.brachyura.fabric.Yarn;
import io.github.coolcrabs.brachyura.mappings.tinyremapper.MappingTreeMappingProvider;
import io.github.coolcrabs.brachyura.maven.MavenId;
import io.github.coolcrabs.brachyura.minecraft.Minecraft;
import io.github.coolcrabs.brachyura.minecraft.VersionMeta;
import net.fabricmc.mappingio.tree.MappingTree;

public class Buildscript extends FabricProject {
	private static final String MC_VERSION = "1.18.1";
	private static final String MC_MAJOR = "1.18";

  // https://fabricmc.net/develop
	private static final String YARN_VERSION = "22";
	private static final String LOADER_VERSION = "0.13.3";
	private static final String FABRIC_VERSION = "0.46.4";

	private static final String MOD_VERSION = "1.0.0";

	@Override
	public VersionMeta createMcVersion() {
		return Minecraft.getVersion(MC_VERSION);
	}

	@Override
	public MappingTree createMappings() {
		//return Yarn.ofMaven(FabricMaven.URL, FabricMaven.yarn(MC_VERSION + "+build." + YARN_VERSION)).tree;
		return createMojmap();
	}

	@Override
	public FabricLoader getLoader() {
		return new FabricLoader(FabricMaven.URL, FabricMaven.loader(LOADER_VERSION));
	}

	@Override
	public String getModId() {
		return "ordinarytweaks";
	}

	@Override
	public String getVersion() {
		return MOD_VERSION + "+" + MC_MAJOR;
	}

	@Override
	public int getJavaVersion(){
		return 17;
	}

	@Override
	public void getModDependencies(ModDependencyCollector d) {
		//d.addMaven(FabricMaven.URL, new MavenId(FabricMaven.GROUP_ID + ".fabric-api", "fabric-api", FABRIC_VERSION + "+" + MC_MAJOR), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE);
		d.addMaven(FabricMaven.URL, new MavenId(FabricMaven.GROUP_ID + ".fabric-api", "fabric-resource-loader-v0", "0.4.11+3ac43d9565"), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE);
		d.addMaven(FabricMaven.URL, new MavenId(FabricMaven.GROUP_ID + ".fabric-api", "fabric-api-base","0.4.1+b4f4f6cd14"), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE);
		d.addMaven(FabricMaven.URL, new MavenId(FabricMaven.GROUP_ID + ".fabric-api", "fabric-screen-api-v1", "1.0.4+155f865c18"), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE);
		d.addMaven("https://maven.terraformersmc.com/releases/",new MavenId("com.terraformersmc:modmenu:3.0.1"), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE);
		d.addMaven("https://jitpack.io", new MavenId("com.github.Fallen-Breath:conditional-mixin:v0.1.2"),ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE, ModDependencyFlag.JIJ);
		//d.add(new JavaJarDependency(getProjectDir().resolve("jarDeps/modmenu-3.0.1.jar").toAbsolutePath(),null,new MavenId("com.terraformersmc:modmenu:3.0.1")), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE);
		d.addMaven("https://maven.shedaniel.me/",new MavenId("me.shedaniel.cloth:cloth-config-fabric:6.0.42"), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE);
		d.addMaven("https://maven.shedaniel.me/",new MavenId("me.shedaniel.cloth:basic-math:0.6.0"), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE);


	}
}
