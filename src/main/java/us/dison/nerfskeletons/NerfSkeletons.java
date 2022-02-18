package us.dison.nerfskeletons;

import net.fabricmc.api.ModInitializer;
import us.dison.nerfskeletons.config.Config;

public class NerfSkeletons implements ModInitializer {

    @Override
    public void onInitialize() {
        Config.init();
        System.out.println("Nerfing Skeletons by "+Config.getDivergenceFactor()+"x!");
    }
}
