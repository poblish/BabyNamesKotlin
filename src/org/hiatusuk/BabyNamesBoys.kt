package org.hiatusuk

fun main(args: Array<String>) {
    val foreNames = arrayOf("Rohan","Nathaniel","Anthony/Tony","Chris(topher)","Jonathan","Lemur","Noah","Harry","Percy","Peregrine","James","Jamie","Sidney","Gabriel","Leyton","Curtley","Jarvis");
    val middleNames = arrayOf("Rohan","Nathaniel","Anthony/Tony","Chris(topher)","Jonathan","Lemur","Noah","Harry","Percy","Peregrine","James","Jamie","Sidney","Gabriel","Leyton","Curtley","Jarvis");

    foreNames.sort()
    middleNames.sort()

//    for (eachName in foreNames) {
//        println(eachName + "has" + syllableCount(eachName) + "syllables")
//    }

    var count = 0

    for (name1 in foreNames) {
        count++
        println("" + count + " ... " + name1 + " Jordan-Regan")

        val syllables1 = syllableCount(name1)

        for (name2 in middleNames) {
            if (name1 != name2) {
                val syllables2 = syllableCount(name2)

                if (name1[0] == name2[0] || (syllables1 == 1 && syllables2 == 1) || (syllables1 == 1 && syllables2 >= 3) || (syllables1 >= 3 && syllables2 >= 3)) {
                    continue
                }

                count++
                println("" + count + " ... " + name1 + " " + name2 + " Jordan-Regan")
            }
        }
    }
}


fun isVowel(inChar: Char) : Boolean {
    return (inChar == 'a' || inChar == 'e' || inChar == 'i' || inChar == 'o' || inChar == 'u')
}

fun syllableCount(inStr: String): Int {
    if (inStr == "Maya") {
        return 2
    }

    var syllables = 0
    var lastChar = '.'
    var wasVowel = false

    for (idx in inStr.indices) {
        val c = inStr[idx]

        if (wasVowel && ((lastChar == 'u' && c == 'a') || (lastChar == 'i' && c == 'a'))) {
            syllables++
        }
        else if (isVowel(c) || c == 'y') {
            if (!wasVowel && (!(c == 'e') || idx < inStr.length - 1)) {
                syllables++
                wasVowel = true
            }
        } else {
            wasVowel = false
        }

        lastChar = c
    }

    if (syllables == 0) {
        return 1
    }

    return syllables
}