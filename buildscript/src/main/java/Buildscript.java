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
		return "fabric-example-mod";
	}

	@Override
	public String getVersion() {
		return MOD_VERSION + "+" + MC_MAJOR;
	}

	@Override
	public void getModDependencies(ModDependencyCollector d) {
		d.addMaven(FabricMaven.URL, new MavenId(FabricMaven.GROUP_ID + ".fabric-api", "fabric-api", FABRIC_VERSION + "+" + MC_MAJOR), ModDependencyFlag.RUNTIME, ModDependencyFlag.COMPILE);
	}
}
