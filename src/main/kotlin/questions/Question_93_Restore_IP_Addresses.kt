package questions

class Question_93_Restore_IP_Addresses {

    companion object {

        fun runQuestion() {
//            Input: s = "101023"
//            Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
            val s = "101023"
            val result = restoreIpAddresses(s)
            println("Question 93: $result")
        }

        fun restoreIpAddresses(s: String): List<String> {
            val result: MutableList<String> = mutableListOf()
            for (i in 1..s.length - 1) {
                for (j in i + 1..s.length - 1) {
                    for (k in j + 1..s.length - 1) {
                        val address = StringBuilder(s)
                        address.insert(k, ".")
                        address.insert(j, ".")
                        address.insert(i, ".")
                        val splittedAddress = address.split(".")
                        var isValid = true
                        for (count in 0..splittedAddress.size - 1) {
                            val value = splittedAddress[count].toIntOrNull()
                            if (value == null) {
                                isValid = false
                                break
                            }
                            if (value > 255 || (splittedAddress[count].length > 1 && splittedAddress[count][0] == '0')) {
                                isValid = false
                                break
                            }
                        }
                        if (isValid) {
                            result.add(address.toString())
                        }
                    }
                }
            }
            return result
        }
    }
}