package net.custom.villagermod.datagen;

import net.custom.villagermod.CustomVillagerMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ModPoiTypeTagsProvider extends PoiTypeTagsProvider {
    public ModPoiTypeTagsProvider(DataGenerator p_236434_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_236434_, CustomVillagerMod.MOD_ID, existingFileHelper);
    }
}
