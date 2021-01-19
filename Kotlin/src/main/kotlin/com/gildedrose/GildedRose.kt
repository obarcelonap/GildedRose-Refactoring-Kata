package com.gildedrose

class GildedRose(val items: Array<Item>) {

    fun updateQuality(): GildedRose {
        val newItems = items.map { updateItem(it) }
            .toTypedArray()

        return GildedRose(newItems)
    }

    private fun updateItem(item: Item): Item = when (item) {
        is Sulfuras -> item.updateQuality()
        is AgedBrie -> item.updateQuality()
        is BackstagePasses -> item.updateQuality()
        is Regular -> item.updateQuality()
        else -> throw NotImplementedError("Missing implementation for item $item")
    }
}

