package us.dison.nerfskeletons.config;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Config {
    public static final String MODID = "nerf-skeletons";

    private static float DIVERGENCE_FACTOR = -1.0f;

    public static void init() {
        File configFile = new File(FabricLoader.getInstance().getConfigDir().toFile(), MODID+".json");
        if (!configFile.exists()) {
            try {
                FileUtils.writeStringToFile(configFile, "{\n\t\"divergence_factor\": 2.0\n}", StandardCharsets.UTF_8);
            } catch (IOException e) {
                System.err.println("Failed to write default config to file "+configFile.getAbsolutePath());
                e.printStackTrace();
            }
        }

        if (DIVERGENCE_FACTOR == -1.0f) {
            try {
                String fileData = FileUtils.readFileToString(configFile, StandardCharsets.UTF_8);
                Gson gson = new Gson();
                ConfigClass configClass = gson.fromJson(fileData, ConfigClass.class);
                DIVERGENCE_FACTOR = configClass.getDivergence();
            } catch (IOException e) {
                System.err.println("Failed to read config file "+configFile.getAbsolutePath());
                e.printStackTrace();
                DIVERGENCE_FACTOR = 1.0f;
            }
        }
    }

    public static float getDivergenceFactor() {
        return DIVERGENCE_FACTOR;
    }
}
