/**
  * Created by edinakim on 2016. 7. 29..
  */
class Classes(val x: Int, y: Int) {
  override def toString:String = s"(hello $x, $y)"
}

object Classes1 extends App {
  val pt = new Classes(1,2)
  pt.x
  println(pt)
}

object Classes2 {
  def main(args: Array[String]):Unit = {
    val pt = new Classes(1,2)

    println(pt)
  }
}