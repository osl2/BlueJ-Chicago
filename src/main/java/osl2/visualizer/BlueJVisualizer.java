package osl2.visualizer;

import bluej.extensions.BlueJ;
import bluej.extensions.Extension;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BlueJVisualizer extends Extension {
	private static final String NAME = "BlueJ Visualizer";
	private static final String DESCRIPTION = "Visualize Datastructures";

	@Override
	public boolean isCompatible() {
		return true;
	}

	@Override
	public void startup(BlueJ blueJ) {
		blueJ.setMenuGenerator(new MenuBuilder());
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public String getVersion() {
		String version = "unknown";
		try (InputStream stream = BlueJVisualizer.class.getResourceAsStream("/META-INF/maven/osl2/BlueJ-Chicago/pom.properties")) {
			if (stream != null) {
				Properties properties = new Properties();
				properties.load(stream);
				version = properties.getProperty("version");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return version;
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
