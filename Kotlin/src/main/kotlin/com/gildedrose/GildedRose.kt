package com.gildedrose

class GildedRose(val items: Array<Item>) {

    fun updateQuality(): GildedRose {
        val newItems = items.map { updateItem(it) }
            .toTypedArray()

        return GildedRose(newItems)
    }

    private fun updateItem(item: Item): Item {
        val sellIn = item.sellIn - 1

        return when (item) {
            is Sulfuras -> item.updateQuality(sellIn)
            is AgedBrie -> item.updateQuality(sellIn)
            is BackstagePasses -> item.updateQuality(sellIn)
            is Regular -> item.updateQuality(sellIn)
            is Conjured -> item.updateQuality(sellIn)
            else -> throw NotImplementedError("Missing implementation for item $item")
        }
    }
}

