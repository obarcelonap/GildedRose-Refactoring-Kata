package com.gildedrose

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name == "Sulfuras, Hand of Ragnaros") {
                item.quality = 80
                item.sellIn = 0
                break
            }

            if (item.quality < 50 && (item.name == "Aged Brie" || item.name == "Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = item.quality + 1

                if (item.name == "Backstage passes to a TAFKAL80ETC concert" && item.quality < 50) {
                    if (item.sellIn < 11) {
                        item.quality = item.quality + 1
                    }
                    if (item.sellIn < 6) {
                        item.quality = item.quality + 1
                    }
                }
            } else if (item.quality > 0) {
                item.quality = item.quality - 1
            }

            item.sellIn = item.sellIn - 1

            if (item.sellIn < 0) {
                if (item.name == "Aged Brie" && item.quality < 50) {
                    item.quality = item.quality + 1
                } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                    item.quality = 0
                } else if (item.quality > 0) {
                    item.quality = item.quality - 1
                }
            }
        }
    }

}

