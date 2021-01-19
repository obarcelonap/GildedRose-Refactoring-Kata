package com.gildedrose

class GildedRose(val items: Array<Item>) {

    fun updateQuality(): GildedRose {
        val newItems = items.map { updateItem(it) }
            .toTypedArray()

        return GildedRose(newItems)
    }

    private fun updateItem(item: Item): Item = when(item.name) {
        "Sulfuras, Hand of Ragnaros" -> Item("Sulfuras, Hand of Ragnaros", 0, 80)
        "Aged Brie" -> updateAgedBrie(item)
        "Backstage passes to a TAFKAL80ETC concert" -> updateBackstagePasses(item)
        else -> updateRegularItem(item)
    }

    private fun updateAgedBrie(item: Item): Item {
        val sellIn = item.sellIn - 1

        var quality = minOf(item.quality + 1, 50)
        if (sellIn < 0) {
            quality = minOf(quality + 1, 50)
        }
        return Item(item.name, sellIn, quality)
    }

    private fun updateBackstagePasses(item: Item): Item {
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

    private fun updateRegularItem(item: Item): Item {
        var quality = maxOf(item.quality - 1, 0)
        val sellIn = item.sellIn - 1

        if (sellIn < 0 && quality > 0) {
            quality = maxOf(quality - 1, 0)
        }
        return Item(item.name, sellIn, quality)
    }
}

