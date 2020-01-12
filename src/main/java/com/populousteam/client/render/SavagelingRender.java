package com.populousteam.client.render;

import com.mojang.blaze3d.platform.GlStateManager;
import com.populousteam.client.model.SavagelingModel;
import com.populousteam.savageandravage.SavageAndRavage;
import com.populousteam.savageandravage.entity.SavagelingEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SavagelingRender<T extends SavagelingEntity> extends MobRenderer<T, SavagelingModel<T>> {
    private static final ResourceLocation TEXTURES = new ResourceLocation(SavageAndRavage.MOD_ID, "textures/entity/savageling.png");

    public SavagelingRender(EntityRendererManager p_i50959_1_) {
        super(p_i50959_1_, new SavagelingModel<>(), 0.3F);
    }

    protected void preRenderCallback(SavagelingEntity entitylivingbaseIn, float partialTickTime) {
        float f = entitylivingbaseIn.getRenderScale();

        GlStateManager.scalef(f, f, f);
    }

  /*  protected float handleRotationFloat(SavagelingEntity livingBase, float partialTicks) {
        float f = MathHelper.lerp(partialTicks, livingBase.oFlap, livingBase.wingRotation);
        float f1 = MathHelper.lerp(partialTicks, livingBase.oFlapSpeed, livingBase.destPos);
        return (MathHelper.sin(f) + 1.0F) * f1;
    }*/

    protected ResourceLocation getEntityTexture(SavagelingEntity entity) {
        return TEXTURES;
    }
}