package com.yotpo.metorikku.metric.stepActions.dataQuality

import com.amazon.deequ.checks.Check
import com.yotpo.metorikku.metric.stepActions.dataQuality.operators.{IsComplete, IsUnique}
import org.apache.log4j.LogManager

case class DataQualityCheck(
                             isComplete: Option[IsComplete] = None,
                             isUnique: Option[IsUnique] = None
                           ) {
  val log = LogManager.getLogger(this.getClass)
  def getCheck(level: String): Check = {
    val check = Seq(isComplete, isUnique).find(
      x => x.isDefined
    ).get.get
    check.getCheck(check.level.getOrElse(level))
  }
}
