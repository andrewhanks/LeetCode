package questions

class Question_1108_Defanging_an_IP_Address {

    companion object {

        fun runQuestion() {
//            Input: address = "1.1.1.1"
//            Output: "1[.]1[.]1[.]1"
            val address = "1.1.1.1"
            val result = defangIPaddr(address)
            println("Question 1108: $result")
        }

        fun defangIPaddr(address: String): String {
            return address.replace(".", "[.]")
        }
    }
}