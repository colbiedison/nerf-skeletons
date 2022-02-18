package us.dison.nerfskeletons.mixin;

import net.minecraft.entity.mob.AbstractSkeletonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import us.dison.nerfskeletons.config.Config;

@Mixin(AbstractSkeletonEntity.class)
public class AbstractSkeletonEntityMixin {
    @ModifyArg(
            method = "attack(Lnet/minecraft/entity/LivingEntity;F)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/projectile/PersistentProjectileEntity;setVelocity(DDDFF)V"),
            index = 4
    )
    private float modifyDivergence(float original) {
        return original * Config.getDivergenceFactor();
    }
}
