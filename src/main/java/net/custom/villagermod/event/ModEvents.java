package net.custom.villagermod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.custom.villagermod.CustomVillagerMod;
import net.custom.villagermod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = CustomVillagerMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomEvents(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.BLOCK_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(Items.DIAMOND_ORE, 12),
                    5, 8, 0.02f
            ));
        }

        if(event.getType() == VillagerProfession.FISHERMAN) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.DIRT, 1),
                    new ItemStack(Items.STONE_BRICKS, 1),
                    5, 8, 0.02f
            ));
        }
    }
}
