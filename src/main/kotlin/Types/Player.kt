package Types


class Player {
    var name: String = ""
    // 决定工资
    var level: Int = 1
    var work: String = "农民工"
    //日工资
    var salary: Int = 100

    var money: Int = 0

    //体力&上限
    var basic: Int = 24
    var max_basic: Int = 24
    //健康&上限
    var health: Int = 10
    var max_health: Int = 10


    fun Look():String{
        return """
${work} lv.${level}
存款:${money}￥
工资:${salary*30}￥/月
体力:${basic}/${max_basic}
健康:${health}/${max_health}"""
    }

    //第一次时，注册
    fun Register(){

    }
}