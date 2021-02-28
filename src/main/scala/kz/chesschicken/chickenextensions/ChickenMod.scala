package kz.chesschicken.chickenextensions

import net.modificationstation.stationapi.api.common.registry.ModID

import java.awt.Color

object ChickenMod
{
  def get16ColorCode(colortype: Int): Int = {
    colortype match {
      case 0 =>
        new Color(221, 221, 221).getRGB
      case 1 =>
        new Color(219, 125, 62).getRGB
      case 2 =>
        new Color(179, 80, 188).getRGB
      case 3 =>
        new Color(107, 138, 201).getRGB
      case 4 =>
        new Color(177, 166, 39).getRGB
      case 5 =>
        new Color(65, 164, 56).getRGB
      case 6 =>
        new Color(208, 132, 153).getRGB
      case 7 =>
        new Color(64, 64, 64).getRGB
      case 8 =>
        new Color(154, 161, 161).getRGB
      case 9 =>
        new Color(46, 110, 137).getRGB
      case 10 =>
        new Color(126, 61, 181).getRGB
      case 11 =>
        new Color(46, 56, 141).getRGB
      case 12 =>
        new Color(79, 50, 31).getRGB
      case 13 =>
        new Color(53, 70, 27).getRGB
      case 14 =>
        new Color(150, 52, 48).getRGB
      case 15 =>
        new Color(25, 22, 22).getRGB
    }
  }
}

