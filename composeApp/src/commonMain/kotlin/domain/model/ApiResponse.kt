package domain.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.mongodb.kbson.ObjectId

@Serializable
data class ApiResponse(
    val meta: MetaData,
    val data: Map<String, Currency>,
)

@Serializable
data class MetaData(
    @SerialName("last_updated_at")
    val lastUpdatedAt: String,
)

//@Serializable
//data class Currency(
//    val code: String,
//    val value: Double,
//)

// MongoDB 에서 사용하는 Currency 모델로 변환
// 모든 프로퍼티는 val 이 아닌, var 이어야 함
@Serializable
open class Currency : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var code: String = ""
    var value: Double = 0.0
}