package illager.savageandravage.client.render;

import com.mojang.blaze3d.platform.GlStateManager;
import illager.savageandravage.client.model.CreepiesModel;
import illager.savageandravage.client.render.layer.CreepiesChargeLayer;
import illager.savageandravage.entity.CreepiesEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CreepiesRender extends MobRenderer<CreepiesEntity, CreepiesModel<CreepiesEntity>> {
    private static final ResourceLocation CREEPER_TEXTURES = new ResourceLocation("textures/entity/creeper/creeper.png");

    public CreepiesRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CreepiesModel<>(), 0.25F);
        this.addLayer(new CreepiesChargeLayer(this));
    }

    protected void preRenderCallback(CreepiesEntity entitylivingbaseIn, float partialTickTime) {
        GlStateManager.scalef(0.5F, 0.5F, 0.5F);
        float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
        float f1 = 1.0F + MathHelper.sin(f * 100.0F) * f * 0.01F;
        f = MathHelper.clamp(f, 0.0F, 1.0F);
        f = f * f;
        f = f * f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        GlStateManager.scalef(f2, f3, f2);
    }

    protected int getColorMultiplier(CreepiesEntity entitylivingbaseIn, float lightBrightness, float partialTickTime) {
        float f = entitylivingbaseIn.getCreeperFlashIntensity(partialTickTime);
        if ((int) (f * 10.0F) % 2 == 0) {
            return 0;
        } else {
            int i = (int) (f * 0.2F * 255.0F);
            i = MathHelper.clamp(i, 0, 255);
            return i << 24 | 822083583;
        }
    }

    protected ResourceLocation getEntityTexture(CreepiesEntity entity) {
        return CREEPER_TEXTURES;
    }
}