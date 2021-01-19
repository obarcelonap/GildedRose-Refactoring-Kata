package com.gildedrose

open class Item(var name: String, var sellIn: Int, var quality: Int) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

class Regular(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    fun updateQuality(): Regular {
        var quality = maxOf(quality - 1, 0)
        val sellIn = sellIn - 1

        if (sellIn < 0 && quality > 0) {
            quality = maxOf(quality - 1, 0)
        }
        return Regular(name, sellIn, quality)
    }
}

object Sulfuras : Item("Sulfuras, Hand of Ragnaros", 0, 80) {
    fun updateQuality(): Sulfuras = this
}

class AgedBrie(sellIn: Int, quality: Int) : Item("Aged Brie", sellIn, quality) {
    fun updateQuality(): AgedBrie {
        val sellIn = sellIn - 1

        var quality = minOf(quality + 1, 50)
        if (sellIn < 0) {
            quality = minOf(quality + 1, 50)
        }
        return AgedBrie(sellIn, quality)
    }
}

class BackstagePasses(sellIn: Int, quality: Int) : Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) {
    fun updateQuality(): BackstagePasses {
        val sellIn = sellIn - 1

        var quality = minOf(quality + 1, 50)
        if (sellIn < 11) {
            quality = minOf(quality + 1, 50)
        }
        if (sellIn < 6) {
            quality = minOf(quality + 1, 50)
        }

        if (sellIn < 0) {
            quality = 0
        }
        return BackstagePasses(sellIn, quality)
    }
}
