package illager.savageandravage.client.render;

import illager.savageandravage.SavageAndRavageCore;
import illager.savageandravage.client.model.FriendlyRavagerModel;
import illager.savageandravage.client.render.layer.RavagerClothLayer;
import illager.savageandravage.client.render.layer.RavagerSaddleLayer;
import illager.savageandravage.entity.FriendlyRavagerEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class FriendlyRavagerRender extends MobRenderer<FriendlyRavagerEntity, FriendlyRavagerModel> {
    private static final ResourceLocation FRIENDLYRAVAGER_TEXTURE = new ResourceLocation(SavageAndRavageCore.MODID, "textures/entity/friendly_ravager/friendly_ravager_base.png");

    public FriendlyRavagerRender(EntityRendererManager p_i50958_1_) {
        super(p_i50958_1_, new FriendlyRavagerModel(), 1.1F);
        this.addLayer(new RavagerClothLayer(this));
        this.addLayer(new RavagerSaddleLayer(this));
    }

    protected ResourceLocation getEntityTexture(FriendlyRavagerEntity entity) {
        return FRIENDLYRAVAGER_TEXTURE;
    }

}
