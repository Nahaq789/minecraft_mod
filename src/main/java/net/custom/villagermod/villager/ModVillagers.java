package net.custom.villagermod.villager;

import com.google.common.collect.ImmutableSet;
import net.custom.villagermod.CustomVillagerMod;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {

    private static final String BLOCK_MASTER_NAME = "block_master";

    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, CustomVillagerMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSION = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, CustomVillagerMod.MOD_ID);

    public static final RegistryObject<PoiType> BLOCK_POI = POI_TYPES.register("block_poi",
            () -> new PoiType(
                    ImmutableSet.copyOf(Blocks.DIAMOND_ORE.getStateDefinition().getPossibleStates()), 1, 1));

    public static final RegistryObject<VillagerProfession> BLOCK_MASTER =
            VILLAGER_PROFESSION.register(BLOCK_MASTER_NAME, () -> new VillagerProfession(
                    BLOCK_MASTER_NAME,
                    holder -> holder.get() == BLOCK_POI.get(),
                    holder -> holder.get() == BLOCK_POI.get(),
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSION.register(eventBus);
    }

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class, "registerBlockStates", PoiType.class).invoke(null, BLOCK_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }
}
