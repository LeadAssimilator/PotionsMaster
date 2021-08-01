package com.thevortex.potionsmaster.items.potions.effect.oresight;

import com.thevortex.potionsmaster.PotionsMaster;
import com.thevortex.potionsmaster.init.ModPotionEffects;
import com.thevortex.potionsmaster.reference.Ores;
import com.thevortex.potionsmaster.render.util.BlockData;
import com.thevortex.potionsmaster.render.util.BlockStore;
import com.thevortex.potionsmaster.render.util.BlockStore.BlockDataWithUUID;
import com.thevortex.potionsmaster.render.util.xray.Controller;

import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AllthemodiumPotionEffect extends Effect {

    public AllthemodiumPotionEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {

        return true;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void applyEffectTick(LivingEntity entityLivingBaseIn, int amplifier) {
        BlockStore store = PotionsMaster.blockStore;
        if (entityLivingBaseIn instanceof ClientPlayerEntity) {
            BlockDataWithUUID bdUUID = store.getStoreByReference(Ores.ALLTHEMODIUM.toString());
            BlockData ALLTHEMODIUM = bdUUID.getBlockData();
            if ((!ALLTHEMODIUM.isDrawing()) && (!(entityLivingBaseIn.getEffect(ModPotionEffects.ALLTHEMODIUMSIGHT) == null))) {
                ALLTHEMODIUM.setDrawing(true);
            }
            if (!Controller.drawOres()) {
                Controller.toggleDrawOres();
            }

            super.applyEffectTick(entityLivingBaseIn, amplifier);
        }
    }


}
