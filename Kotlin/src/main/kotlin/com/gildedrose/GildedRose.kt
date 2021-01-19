package com.gildedrose

class GildedRose(val items: Array<Item>) {

    fun updateQuality(): GildedRose {
        val newItems = items.map { updateItem(it) }
            .toTypedArray()

        return GildedRose(newItems)
    }

    private fun updateItem(item: Item): Item {
        if (item.name == "Sulfuras, Hand of Ragnaros") {
            return Item("Sulfuras, Hand of Ragnaros", 0, 80)
        }

        if (item.name == "Aged Brie") {
            val sellIn = item.sellIn - 1

        var quality = minOf(item.quality + 1, 50)
        if (sellIn < 0) {
            quality = minOf(quality + 1, 50)
        }
        return Item(item.name, sellIn, quality)
    }

        if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
            val sellIn = item.sellIn - 1

            var quality = minOf(item.quality + 1, 50)
            if (sellIn < 11) {
                quality = minOf(quality + 1, 50)
            }
            if (sellIn < 6) {
                quality = minOf(quality + 1, 50)
            }

        if (sellIn < 0) {
            quality = 0
        }
        return Item(item.name, sellIn, quality)
    }

        // Regular item
        var quality = maxOf(item.quality - 1, 0)
        val sellIn = item.sellIn - 1

        if (sellIn < 0 && quality > 0) {
            quality = maxOf(quality - 1, 0)
        }
        return Item(item.name, sellIn, quality)
    }

}

