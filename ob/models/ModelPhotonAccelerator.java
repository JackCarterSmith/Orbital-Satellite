package fr.jackcartersmith.ob.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPhotonAccelerator extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;

    public ModelPhotonAccelerator()
    {
        this.textureWidth = 128;
        this.textureHeight = 32;
        this.Shape1 = new ModelRenderer(this, 0, 0);
        this.Shape1.addBox(-8.0F, -10.0F, -8.0F, 16, 11, 16);
        this.Shape1.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.Shape1.setTextureSize(128, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
        this.Shape2 = new ModelRenderer(this, 64, 0);
        this.Shape2.addBox(-7.0F, 0.0F, -7.0F, 14, 1, 14);
        this.Shape2.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.Shape2.setTextureSize(128, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
        this.Shape3 = new ModelRenderer(this, 85, 15);
        this.Shape3.addBox(0.0F, 0.0F, -1.0F, 1, 12, 2);
        this.Shape3.setRotationPoint(-2.0F, 2.0F, 0.0F);
        this.Shape3.setTextureSize(128, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0F, 0.0F, 0.4014257F);
        this.Shape4 = new ModelRenderer(this, 85, 15);
        this.Shape4.addBox(0.0F, 0.0F, 0.0F, 1, 12, 2);
        this.Shape4.setRotationPoint(1.0F, 2.0F, -1.0F);
        this.Shape4.setTextureSize(128, 32);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.0F, 0.0F, -0.4120629F);
        this.Shape5 = new ModelRenderer(this, 97, 15);
        this.Shape5.addBox(-1.0F, -12.0F, -1.0F, 4, 13, 4);
        this.Shape5.setRotationPoint(-1.0F, 2.066667F, -1.0F);
        this.Shape5.setTextureSize(128, 32);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
        this.Shape6 = new ModelRenderer(this, 85, 16);
        this.Shape6.addBox(-1.0F, 0.0F, 2.0F, 2, 12, 1);
        this.Shape6.setRotationPoint(0.0F, 2.0F, -1.0F);
        this.Shape6.setTextureSize(128, 32);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, 0.3839724F, 0.0F, 0.0F);
        this.Shape7 = new ModelRenderer(this, 85, 16);
        this.Shape7.addBox(0.0F, 0.0F, 0.0F, 2, 12, 1);
        this.Shape7.setRotationPoint(-1.0F, 1.5F, -2.0F);
        this.Shape7.setTextureSize(128, 32);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, -0.3839724F, 0.0F, 0.0F);
        this.Shape8 = new ModelRenderer(this, 51, 0);
        this.Shape8.addBox(-3.0F, -3.0F, -3.0F, 6, 1, 6);
        this.Shape8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape8.setTextureSize(128, 32);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
        this.Shape9 = new ModelRenderer(this, 51, 0);
        this.Shape9.addBox(-3.0F, -1.0F, -3.0F, 6, 1, 6);
        this.Shape9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Shape9.setTextureSize(128, 32);
        this.Shape9.mirror = true;
        this.setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
        this.Shape10 = new ModelRenderer(this, 51, 0);
        this.Shape10.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
        this.Shape10.setRotationPoint(-3.0F, -5.0F, -3.0F);
        this.Shape10.setTextureSize(128, 32);
        this.Shape10.mirror = true;
        this.setRotation(this.Shape10, 0.0F, 0.0F, 0.0F);
        this.Shape11 = new ModelRenderer(this, 51, 0);
        this.Shape11.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
        this.Shape11.setRotationPoint(-3.0F, -7.0F, -3.0F);
        this.Shape11.setTextureSize(128, 32);
        this.Shape11.mirror = true;
        this.setRotation(this.Shape11, 0.0F, 0.0F, 0.0F);
        this.Shape12 = new ModelRenderer(this, 51, 0);
        this.Shape12.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
        this.Shape12.setRotationPoint(-3.0F, -9.0F, -3.0F);
        this.Shape12.setTextureSize(128, 32);
        this.Shape12.mirror = true;
        this.setRotation(this.Shape12, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
        this.Shape5.render(f5);
        this.Shape6.render(f5);
        this.Shape7.render(f5);
        this.Shape8.render(f5);
        this.Shape9.render(f5);
        this.Shape10.render(f5);
        this.Shape11.render(f5);
        this.Shape12.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
    }

    public void renderAll()
    {
        this.Shape1.render(0.0625F);
        this.Shape2.render(0.0625F);
        this.Shape3.render(0.0625F);
        this.Shape4.render(0.0625F);
        this.Shape5.render(0.0625F);
        this.Shape6.render(0.0625F);
        this.Shape7.render(0.0625F);
    }
}