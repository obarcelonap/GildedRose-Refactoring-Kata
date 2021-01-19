package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `lower by 1 sellIn and quality on update`() {
        val items = arrayOf<Item>(Regular("foo", 5, 5))
        val app = GildedRose(items)
        val updatedApp = app.updateQuality()

        with(updatedApp.items.first()) {
            assertEquals(4, sellIn)
            assertEquals(4, quality)
        }
    }

    @Test
    fun `lower by 2 quality when sellIn is less than 0`() {
        val items = arrayOf<Item>(Regular("foo", -1, 50))
        val app = GildedRose(items)
        val updatedApp = app.updateQuality()

        with(updatedApp.items.first()) {
            assertEquals(48, quality)
        }
    }

    @Test
    fun `quality is never negative`() {
        val items = arrayOf<Item>(Regular("foo", 0, 0))
        val app = GildedRose(items)
        val updatedApp = app.updateQuality()

        with(updatedApp.items.first()) {
            assertEquals(0, quality)
        }
    }

    @Test
    fun `"Aged Brie" increases in quality the older it gets`() {
        val items = arrayOf<Item>(AgedBrie(0, 0))
        val app = GildedRose(items)
        val updatedApp = app.updateQuality()

        with(updatedApp.items.first()) {
            assertEquals(2, quality)
        }
    }

    @Test
    fun `quality is never more than 50`() {
        val items = arrayOf<Item>(AgedBrie(0, 50))
        val app = GildedRose(items)
        val updatedApp = app.updateQuality()

        with(updatedApp.items.first()) {
            assertEquals(50, quality)
        }
    }

    @Test
    fun `"Sulfuras" never has to be sold or decreases in quality`() {
        val items = arrayOf<Item>(Sulfuras)
        val app = GildedRose(items)
        val updatedApp = app.updateQuality()

        with(updatedApp.items.first()) {
            assertEquals(0, sellIn)
            assertEquals(80, quality)
        }
    }

    @Test
    fun `"Backstage passes" increases quality by 2 when there are 10 days or less`() {
        val items = arrayOf<Item>(BackstagePasses(10, 0))
        val app = GildedRose(items)
        val updatedApp = app.updateQuality()

        with(updatedApp.items.first()) {
            assertEquals(2, quality)
        }
    }

    @Test
    fun `"Backstage passes" increases quality by 3 when there are 5 days or less`() {
        val items = arrayOf<Item>(BackstagePasses(5, 0))
        val app = GildedRose(items)
        val updatedApp = app.updateQuality()

        with(updatedApp.items.first()) {
            assertEquals(3, quality)
        }
    }

    @Test
    fun `"Backstage passes" quality drops to 0 after the concert`() {
        val items = arrayOf<Item>(BackstagePasses(0, 5))
        val app = GildedRose(items)
        val updatedApp = app.updateQuality()

        with(updatedApp.items.first()) {
            assertEquals(0, quality)
        }
    }

    @Test
    fun `"Conjured" degrade in quality twice as fast as normal items when there are days`() {
        val items = arrayOf<Item>(Conjured(1, 5))
        val app = GildedRose(items)
        val updatedApp = app.updateQuality()

        with(updatedApp.items.first()) {
            assertEquals(3, quality)
        }
    }

    @Test
    fun `"Conjured" degrade in quality twice as fast as normal items when there aren't days`() {
        val items = arrayOf<Item>(Conjured(0, 5))
        val app = GildedRose(items)
        val updatedApp = app.updateQuality()

        with(updatedApp.items.first()) {
            assertEquals(1, quality)
        }
    }
}


