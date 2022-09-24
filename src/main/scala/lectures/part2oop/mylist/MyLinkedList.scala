package lectures.part2oop.mylist

import lectures.part2oop.mylist.MyList

import java.util.Optional
import scala.annotation.tailrec

class MyLinkedList[T] extends MyList[T] {

  private var head: Option[Node[T]] = Option.empty
  private var tail: Option[Node[T]] = Option.empty

  override def isEmpty(): Boolean =  head.isEmpty

  override def add(element: T): Unit = {
    if (head.isEmpty) {
      head = Some(Node(element))
    } else {
      addToTail(head.get, element)
    }
    tail = Some(Node(element))
  }

  override def getHead(): Option[T] = getElement(head)

  override def getTail(): Option[T] = getElement(tail)

  override def toString(): String = {
    return s"[${elementsAsString(head)}]"
  }

  override def map[Z](transformer: MyTransformer[T, Z] ): MyList[Z] = {
    val newList: MyList[Z] = new MyLinkedList[Z]
    mapNextNode(this.head, newList, transformer)
  }

  override def filter(predicate: MyPredicate[T]): MyList[T] = {
    filterIf(this.head, MyLinkedList(), predicate)
  }

  override def fold(accumulator: T, func: (T, T) => T): T = {
    accumulateThrough(this.head, accumulator, func)
  }

  override def foreach(func: (t: T) => Unit): Unit = {
    doActionThrough(func, head)
  }

  @tailrec
  private final def doActionThrough(func: (t: T) => Unit, optNode: Option[Node[T]]): Unit = {
    optNode match
      case Some(node) => {
        func(node.getElement())
        doActionThrough(func, node.next)
      }
      case None => {
        return
      }

  }

  @tailrec
  private final def accumulateThrough(optNode: Option[Node[T]], accumulator: T, func: (T, T) => T): T = {
    optNode match {
      case Some(node) =>
        val newAccumulatedValue = func(accumulator, node.getElement())
        accumulateThrough(node.next, newAccumulatedValue, func)

      case None => accumulator

    }
  }

  @tailrec
  private final def filterIf(optNode: Option[Node[T]], newList: MyList[T], predicate: MyPredicate[T]): MyList[T] = {
    if (optNode.isEmpty) {
      newList
    } else {
      val node = optNode.get
      if (predicate.test(node.getElement())) {
        newList.add(node.getElement())
      }
      filterIf(node.next, newList, predicate)
    }
  }

  @tailrec
  private final def mapNextNode[Z](optNode: Option[Node[T]], newList: MyList[Z], transformer: MyTransformer[T, Z]): MyList[Z] = {
    if (optNode.isEmpty) {
      newList
    } else {
      val node = optNode.get
      val transformedElement = transformer.apply(node.getElement())
      newList.add(transformedElement)
      mapNextNode(node.next, newList, transformer)
    }
  }

  @tailrec
  private final def elementsAsString(optNode: Option[Node[T]], accumulator: String = ""): String = {
    if (optNode.isEmpty) {
      return accumulator
    } else {
      val node = optNode.get
      val newStr = if (accumulator == "") {
        node.getElement().toString
      } else {
        s"${accumulator}, ${node.getElement().toString}"
      }
      elementsAsString(node.next, newStr)
    }
  }

  @tailrec
  private final def addToTail(node: Node[T], element: T): Unit = {
    if (node.next.isEmpty) {
      node.next = Some(Node(element))
    } else {
      addToTail(node.next.get, element)
    }
  }

  private final def getElement(optNode: Option[Node[T]]): Option[T]= {
    if (!optNode.isEmpty) {
      return Some(tail.get.getElement())
    }
    return None
  }

  private final class Node[T](obj: T, var next: Option[Node[T]] = None) {
    def setNext(node: Node[T]): Unit = {
      this.next = Some(node)
    }
    def getElement() = obj
  }
}