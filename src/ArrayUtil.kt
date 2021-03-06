package arrays

import java.util.*

object ArrayUtil {
    /**
     * fill
     * Дан массив целых чисел.
     * Заполнить данный массив с клавиатуры. Scanner подать как аргумент метода
     */
    fun fill(arr: IntArray, scanner: Scanner) {
        for (i in arr.indices) {
            arr[i] = scanner.nextInt()
        }
    }

    /**
     * toString
     * Дан массив целых чисел.
     * Преобразовать данный массив в строковое значение в формате JSON
     * Пример:
     * [10, 2, 6, 4]
     */
    fun toString(arr: IntArray): String {
        var s = ""
        var has = false
        for (value in arr) {
            if (has) s += ", "
            s += value
            has = true
        }
        return "[$s]"
    }

    /**
     * evenData
     * Дан массив целых чисел. Выведите все четные элементы массива.
     * Указание:
     * Для проверки четности элемента массива реализовать отдельный метод isEven,
     * который будет проверять, является ли переданный ей элемент четным.
     * Решение оформить 2 способами:
     * -возвращать строковое представление массива в формате JSON
     */
    private fun isEven(number: Int): Boolean {
        return number % 2 == 0
    }

    fun evenData(arr: IntArray): String {
        var s = ""
        var has = false
        for (i in arr.indices) {
            if (isEven(arr[i])) {
                if (has) {
                    s += ", "
                }
                s += arr[i]
                has = true
            }
        }
        return "[$s]"
    }

    /**
     * Дан массив целых чисел. Заполнить данный массив числами в диапазоне от a до b
     * Указание:
     * Для генерации случайного числа в диапазоне от a до b реализовать отдельный метод getRandomNumber
     */
    fun getRandomNumber(a: Int, b: Int): Int {
        return (Math.random() * (b - a) + a).toInt()
    }

    fun fillRandom(arr: IntArray, a: Int, b: Int) {
        for (i in arr.indices) {
            arr[i] = getRandomNumber(a, b)
        }
    }

    /**
     * Дан массив целых чисел. Выведите все элементы массива с четными индексами.
     * В программе запрещено использовать условную инструкцию для проверки четности индексов.
     * (Цикл по четным индексам)
     * Решение оформить 2 способами:
     * -возвращать строковое представление массива в формате JSON
     */
    fun evenIndexes(arr: IntArray): String {
        var s = ""
        var has = false
        var i = 0
        while (i < arr.size) {
            if (has) {
                s += ", "
            }
            s += arr[i]
            has = true
            i += 2
        }
        return "[$s]"
    }

    /**
     * Дан массив целых чисел.
     * Определить количество положительных элементов в данном массиве.
     */
    fun countPositive(arr: IntArray): Int {
        var count = 0
        for (i in arr.indices) {
            if (arr[i] > 0) {
                count++
            }
        }
        return count
    }

    /**
     * Дан массив целых чисел. Выведите все элементы массива,
     * которые больше предыдущего элемента.
     * Решение оформить 2 способами:
     * -возвращать строковое представление массива в формате JSON
     * -используя ArrayList для накопления элементов, удовлетворяющих условию задачи
     */
    fun greatPrev(arr: IntArray): String {
        var s = ""
        var has = false
        for (i in 0 until arr.size - 1) {
            if (arr[i] < arr[i + 1]) {
                if (has) {
                    s += ", "
                }
                s += arr[i + 1]
                has = true
            }
        }
        return "[$s]"
    }

    /**
     * Дан массив целых чисел.
     * Выведите значение наибольшего элемента в массиве
     */
    fun max(arr: IntArray): Int {
        var max = Int.MIN_VALUE
        for (i in arr.indices) {
            if (arr[i] > max) max = arr[i]
        }
        return max
    }

    fun sameNeighbours(arr: IntArray): IntArray {
        for (i in 0 until arr.size - 1) {
            if (arr[i] > 0 && arr[i + 1] > 0 || arr[i] < 0 && arr[i + 1] < 0) {
                return intArrayOf(arr[i], arr[i + 1])
            }
        }
        return IntArray(0)
    }

    /**
     * greaterNeighbours
     * Дан массив целых чисел. Определите, сколько в этом массиве элементов,
     * которые больше двух своих соседей и выведите количество таких элементов.
     */
    fun greaterNeighbours(arr: IntArray): Int {
        var count = 0
        for (i in 1 until arr.size - 1) {
            if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
                count++
            }
        }
        return count
    }

    /**
     * minPositive
     * Дан массив целых чисел.
     * Выведите значение наименьшего из всех положительных элементов в массиве. Известно, что в массиве есть хотя бы один положительный элемент.
     */
    fun minPositive(arr: IntArray): Int {
        var min = Int.MAX_VALUE
        for (i in arr.indices) {
            if (arr[i] > 0 && arr[i] < min) {
                min = arr[i]
            }
        }
        return min
    }

    /**
     * minOdd
     * Дан массив целых чисел. Выведите значение наименьшего нечетного элемента массива,
     * а если в массиве нет нечетных элементов см. способы реализации.
     * Указание:
     * Для проверки нечетности элемента использовать заранее написанную функцию из п.5
     * Решение оформить 2 способами:
     * -Вернуть значение 0 при отсутствии элементов, удовлетворяющих условию задачи
     * -Вернуть значение null, указав тип возвращаемого значения объектную оболочку типа int – Integer.
     */
    fun minOdd(arr: IntArray): Int {
        var min = Int.MAX_VALUE
        var bool = false
        for (i in arr.indices) {
            if (!isEven(arr[i]) && min > arr[i]) {
                min = arr[i]
                bool = true
            }
        }
        /*if (bool) {
            return min;
        } else
            return 0;*/return if (bool) min else 0
    }

    fun minOddInteger(arr: IntArray): Int? {
        var min = Int.MAX_VALUE
        var bool = false
        for (i in arr.indices) {
            if (!isEven(arr[i]) && min > arr[i]) {
                min = arr[i]
                bool = true
            }
        }
        return if (bool) min else null
    }

    /**
     * nearest
     * Дан массив целых чисел и число x. Найдите в данном массиве элемент,
     * ближайший к x(элемент с минимальной абсолютной разницей с х).
     * Если таких чисел несколько, выведите см. способы реализации.
     * Решение оформить 3 способами:
     * -Вернуть последний элемент, удовлетворяющий условиям задачи
     */
    fun nearest(arr: IntArray, x: Int): Int {
        var index = 0
        var num = Int.MAX_VALUE
        for (i in arr.indices) {
            val abs = Math.abs(x - arr[i])
            if (abs <= num) {
                num = abs
                index = arr[i]
            }
        }
        return index
    }

    /**
     * indexInsertion
     * Дана невозрастающая последовательность целых чисел в виде массива и число x.
     * Вывести номер этой последовательности, куда можно было бы вставить данных элемент х,
     * чтобы правило не возрастания сохранилось, учитывая, что нумерация элементов в последовательности начинается с 1.
     * Если в последовательности уже есть элементы,
     * равные х, то считается, что данный элемент вставляется после них.
     */
    fun indexInsertion(arr: IntArray, x: Int): Int {
        for (i in arr.indices) {
            if (x > arr[i]) return i + 1
        }
        return arr.size + 1
    }

    /**
     * countDifferent
     * Дан массив целых чисел, УПОРЯДОЧЕННЫЙ по неубыванию элементов в нем.
     * Определите, сколько в нем различных элементов.Решение в один цикл.
     * Пример:
     * 1 1 2 3 ->3
     * 1 2 3 ->3
     * 1 1 1 ->1
     */
    fun countDifferent(arr: IntArray): Int {
        var count = 0
        for (i in 0 until arr.size - 1) {
            if (arr[i] != arr[i + 1]) {
                count++
            }
        }
        return count + 1
    }

    fun different(arr: IntArray, num: Int): Int {
        var count = 0
        for (i in arr.indices) {
            if (num != arr[i]) count++
        }
        return count
    }

    /**
     * reverse(метод должен быть void, не использовать вспомогательный массив)
     * Дан массив целых чисел. Переставьте элементы данного массива в обратном порядке.
     * Метод должен производить разворот исходного массива, ничего не возвращая.
     */
    fun reverse(arr: IntArray) {
        var num: Int
        for (i in 0 until arr.size / 2) {
            num = arr[arr.size - i - 1]
            arr[arr.size - i - 1] = arr[i]
            arr[i] = num
        }
    }

    /**
     * reverseNeighbours
     * Дан массив целых чисел.
     * Переставьте соседние элементы массива.
     * Если элементов нечетное число,
     * то последний элемент остается на своем месте.
     */
    fun reverseNeighbours(arr: IntArray) {
        var i = 0
        while (i < arr.size - 1) {
            val temp = arr[i]
            arr[i] = arr[i + 1]
            arr[i + 1] = temp
            i += 2
        }
    }

    /**
     * countEqualPairs
     * Дан массив целых чисел.
     * Посчитайте, сколько в нем пар элементов,
     * равных друг другу. Считается, что любые два элемента,
     * равные друг другу образуют одну пару, которую необходимо посчитать.
     */
    fun countEqualPairs(arr: IntArray): Int {
        var count = 0
        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                if (arr[i] == arr[j]) {
                    count++
                }
            }
        }
        return count
    }

    /**
     * shift
     * Дан массив целых чисел и параметр k.
     * Если данный параметр истинный, то выполнить циклический сдвиг массива на одну позицию вправо,
     * если ложный, то влево.
     * Метод должен производить операции над массивом, ничего не возвращая.
     */
    fun shift(arr: IntArray, k: Boolean) {
        if (k) {
            val temp = arr[arr.size - 1]
            for (i in arr.size - 1 downTo 1) {
                arr[i] = arr[i - 1]
            }
            arr[0] = temp
        } else {
            val temp = arr[0]
            for (i in 0 until arr.size - 1) {
                arr[i] = arr[i + 1]
            }
            arr[arr.size - 1] = temp
        }
    }

    /**
     * shift(делать вызов метода из задачи 21)
     * Дан массив целых чисел и число k.
     * Выполнить циклический сдвиг массива на |k| позиций вправо, если k>0 или влево, если k<0.
     * Метод должен производить операции над массивом, ничего не возвращая.
     */
    fun shiftCount(arr: IntArray, k: Int) {
        for (i in 0 until Math.abs(k)) {
            shift(arr, k > 0)
        }
    }

    /**
     * countDifferent
     * Дан массив целых чисел.
     * Посчитайте,сколько в нем различных элементов, не изменяя самого массива.
     */
    fun countDifferent24(arr: IntArray) {
        var count = 0
        for (i in arr.indices) {
            var flag = false
            for (j in i + 1 until arr.size) {
                if (arr[i] == arr[j]) {
                    flag = true
                    break
                }
            }
            if (!flag) count++
        }
    }

    /**
     * unique
     * Дан массив целых чисел. Выведите те его элементы, которые встречаются в массиве только один раз.
     * Элементы нужно выводить в том порядке, в котором они встречаются в массиве.
     * Решение оформить 2 способами:
     * -использовать вспомогательный массив для хранения элементов
     * -использовать ArrayList для накопления элементов, удовлетворяющих условию задачи
     */
    fun uniqueCount(arr: IntArray): Int {
        var size = 0
        for (i in arr.indices) {
            var flag = true
            for (j in arr.indices) {
                if (arr[i] == arr[j] && i != j) {
                    flag = false
                    break
                }
            }
            if (flag) {
                size++
            }
        }
        return size
    }

    fun unique(arr: IntArray): IntArray {
        val length = uniqueCount(arr)
        var size = 0
        val array = IntArray(length)
        for (i in arr.indices) {
            var flag = true
            for (j in arr.indices) {
                if (arr[i] == arr[j] && i != j) {
                    flag = false
                    break
                }
            }
            if (flag) {
                array[size] = arr[i]
                size++
            }
        }
        return array
    }

    fun uniqueArrayList(arr: IntArray): Array<Int> {
        val integerArrayList = ArrayList<Int>()
        for (i in arr.indices) {
            var flag = true
            for (j in arr.indices) {
                if (arr[i] == arr[j] && i != j) {
                    flag = false
                    break
                }
            }
            if (flag) {
                integerArrayList.add(arr[i])
            }
        }
        return integerArrayList.toTypedArray()
    }

    /**
     * frequent
     * Дан массив целых чисел. Не изменяя массива определить, какое число в этом массиве встречается чаще всего.
     * Если таких чисел несколько, выведите см. способы реализации.
     * Решение оформить 3 способами:
     * -Вернуть первый элемент, удовлетворяющий условиям задачи+
     * -Вернуть все элементы, удовлетворяющие условиям задачи, используя дополнительный массив
     * -Вернуть все элементы, удовлетворяющие условиям задачи, используя ArrayList
     */
    fun frequentFistElement(arr: IntArray): Int {
        var maxFrequent = 0
        var num = 0
        for (i in arr.indices) {
            var frequent = 0
            for (j in i until arr.size) {
                if (arr[i] == arr[j]) {
                    frequent++
                }
            }
            if (frequent > maxFrequent) {
                maxFrequent = frequent
                num = arr[i]
            }
        }
        return num
    }

    /**
     * Вернуть все элементы, удовлетворяющие условиям задачи, используя ArrayList
     */
    fun frequentArrayList(arr: IntArray): Array<Int> {
        var maxFrequent = 0
        for (i in arr.indices) {
            var frequent = 0
            for (j in i until arr.size) {
                if (arr[i] == arr[j]) {
                    frequent++
                }
            }
            if (frequent > maxFrequent) {
                maxFrequent = frequent
            }
        }
        val integerArrayList = ArrayList<Int>()
        for (i in arr.indices) {
            var frequentCount = 0
            for (j in i until arr.size) {
                if (arr[i] == arr[j]) {
                    frequentCount++
                }
            }
            if (frequentCount == maxFrequent) {
                integerArrayList.add(arr[i])
            }
        }
        return integerArrayList.toTypedArray()
    }

    /**
     * Вернуть все элементы, удовлетворяющие условиям задачи, используя дополнительный массив
     */
    fun frequentArr(arr: IntArray): IntArray {
        var maxFrequent = 0
        for (i in arr.indices) {
            var frequent = 0
            for (j in i until arr.size) {
                if (arr[i] == arr[j]) {
                    frequent++
                }
            }
            if (frequent > maxFrequent) {
                maxFrequent = frequent
            }
        }
        var length = 0
        for (i in arr.indices) {
            var frequentCount = 0
            for (j in i until arr.size) {
                if (arr[i] == arr[j]) {
                    frequentCount++
                }
            }
            if (frequentCount == maxFrequent) {
                length++
            }
        }
        val arrFrequent = IntArray(length)
        var size = 0
        for (i in arr.indices) {
            var frequentCount = 0
            for (j in i until arr.size) {
                if (arr[i] == arr[j]) {
                    frequentCount++
                }
            }
            if (frequentCount == maxFrequent) {
                arrFrequent[size++] = arr[i]
            }
        }
        return arrFrequent
    }

    /**
     * search
     * Дан массив целых чисел и число key.
     * Методом линейного поиска при помощи цикла for найти индекс вхождения числа key в массиве
     * 29.1 search
     * Модернизировать программу таким образом,  чтобы она вернула индексы всех вхождений числа key в массиве.
     * Решение оформить 2 способами:
     * -использовать массив для хранения элементов
     * -использовать ArrayList для накопления элементов
     */
    fun search(key: Int, arr: IntArray): IntArray {
        var length = 0
        for (i in arr.indices) {
            if (key == arr[i]) {
                length++
            }
        }
        val array = IntArray(length)
        var i = 0
        var size = 0
        while (i < arr.size) {
            if (key == arr[i]) {
                array[size++] = i
            }
            i++
        }
        return array
    }

    fun searchArrayList(arr: IntArray, key: Int): ArrayList<Int> {
        val integerArrayList = ArrayList<Int>()
        for (i in arr.indices) {
            if (key == arr[i]) {
                integerArrayList.add(i)
            }
        }
        return integerArrayList
    }

    fun searchFirstElement(key: Int, arr: IntArray): Int {
        for (i in arr.indices) {
            if (key == arr[i]) {
                return i
            }
        }
        return -1
    }

    /**
     * Написать метод который принимает на вход два двумерных массива и возвращает их сумму.
     */
//    @Throws(InsufficientSizeArray::class)
//    fun sumArr(arrFist: Array<IntArray>, arrSecond: Array<IntArray>): Array<IntArray> {
//        if (arrFist.size != arrSecond.size || arrFist[0].length != arrSecond[0].length) {
//            throw InsufficientSizeArray("Длины массивов не совпадают")
//        }
//        val arr = Array(arrFist.size) {
//            IntArray(
//                arrFist[0].length
//            )
//        }
//        for (i in arr.indices) {
//            for (j in 0 until arr[i].length) {
//                arr[i][j] = arrFist[i][j] + arrSecond[i][j]
//            }
//        }
//        return arr
//    }

    /**
     * Написать метод который принимает на вход двумерный массив и возвращает произведение его диагональных элементов.
     */
    fun multipleArrDiag(arr: Array<IntArray>): Int {
        var multiple = 1
        for (i in arr.indices) {
            multiple *= arr[i][i]
        }
        return multiple
    }

    //1 2 3 4
    //1 2 3
    fun equalsIgnoreCase(arrFirst: IntArray, arrSecond: IntArray): Boolean {
        var equalsArr = true
        for (i in arrFirst.indices) {
            equalsArr = false
            for (j in arrSecond.indices) {
                if (arrFirst[i] == arrSecond[j]) {
                    equalsArr = true
                }
            }
            if (!equalsArr) {
                return false
            }
        }
        for (i in arrSecond.indices) {
            equalsArr = false
            for (j in arrFirst.indices) {
                if (arrSecond[i] == arrFirst[j]) {
                    equalsArr = true
                }
            }
            if (!equalsArr) {
                return false
            }
        }
        return true
    }

    /**
     * equals
     * Даны два массива целых чисел. Сравнить их на равенство.
     * Указание:
     * Под равенством двух массивов понимать их тождественное равенство,
     * то есть два массива с одинаковыми длинами, одинаковыми элементами,
     * но разным порядком этих элементов считаются разными
     */
    fun equals(arrFirst: IntArray, arrSecond: IntArray): Boolean {
        if (arrFirst.size != arrSecond.size) return false
        for (i in arrFirst.indices) {
            if (arrFirst[i] != arrSecond[i]) return false
        }
        return true
    }

    /**
     * copyOf
     * Дан массив, сделать его копию
     * Указание:
     * Метод должен принимать на вход 2 параметра: исходный массив, который надо скопировать и длину нового массива.
     * Если длина исходного массива больше длины нового массива, то копируется только часть исходного массива,
     * если длина исходного массива меньше длины нового массива, то в новый массив исходный массив копируется полностью,
     * а оставшаяся незаполненная часть записывается нулями,
     * если же размер нового массива совпадает с размером исходного, то в новый массив копируется полностью исходный.
     */
    fun copyOf(arr: IntArray, length: Int): IntArray {
        val copyArr = IntArray(length)
        val min = Math.min(copyArr.size, arr.size)
        for (i in 0 until min) {
            copyArr[i] = arr[i]
        }
        return copyArr
    }

    /**
     * copyOfRange
     * Дан массив и два целых числа b и e, сделать копию исходного массива начиная с индекса а и заканчивая b
     * Указание:
     * Метод должен принимать на вход 3 параметра: исходный массив,
     * который надо скопировать и границы копирования. Если длина исходного массива меньше числа a,
     * то вернуть null.
     * Если длина исходного массива меньше  числа b, то в новый массив исходный массив копируется полностью,
     * а оставшаяся незаполненная часть записывается нулями.
     */
    fun copyOfRange(arr: IntArray, a: Int, b: Int): IntArray? {
        if (a > arr.size) {
            return null
        }
        val length = b - a
        if (length <= 0) {
            throw NegativeArraySizeException("Длина массива не может быть отрицательной или равной нулю")
        }
        val copyArr = IntArray(length + 1)
        if (copyArr.size < arr.size) {
            var i = 0
            var j = a
            while (i < copyArr.size) {
                copyArr[i] = arr[j]
                i++
                j++
            }
        } else {
            var i = 0
            var j = a
            while (i < arr.size - a) {
                copyArr[i] = arr[j]
                i++
                j++
            }
        }
        return copyArr
    }
    /**
     * Sort
     * Дан массив целых чисел. Выполнить сортировку массива пузырьком и сортировкой отбором (линейная сортировка).
     * Решение оформить 2 способами:
     * -Выполнить данные сортировки
     * -Выполнить данные сортировки, принимая в качестве аргумента Comparator для сравнения элементов
     * 32.1 isOrder
     * Дан массив целых чисел. Определить, является ли он упорядоченным
     * 32.2 TesterClass
     * В класс Tester в пакете tests, определить в нем метод,
     * который тестирует метод Протестировать методы sort на случайно сгенерированных 1000 массивах,
     * применяя метод isOrder для проверки, является ли массив упорядоченным после выполнения сортировки,
     * при верности теста выводить sout в формате: ---------test номер_теста is successful,
     * при неверности выводить serr в формате: ---------test номер_теста is invalid.
     */
    /**
     * Сортировка пузырьком
     */
    fun bubbleSort(arr: IntArray, comparator: Comparator<Int?>?) {
        var flag = false
        var num: Int
        while (!flag) {
            flag = true
            for (i in 0 until arr.size - 1) {
                if (arr[i] > arr[i + 1]) { //использовать вместо < метод из обхекта компаратора
                    flag = false
                    num = arr[i]
                    arr[i] = arr[i + 1]
                    arr[i + 1] = num
                }
            }
        }
    }

    fun bubbleSortComparator(arr: IntArray, comparator: Comparator<Int?>) {
        var flag = false
        var num: Int
        while (!flag) {
            flag = true
            for (i in 0 until arr.size - 1) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) { //использовать вместо < метод из обхекта компаратора
                    flag = false
                    num = arr[i]
                    arr[i] = arr[i + 1]
                    arr[i + 1] = num
                }
            }
        }
    }

    /**
     * Линейная сортировка
     */
    fun selectionSort(arr: IntArray, comparator: Comparator<Int?>?) {
        for (i in arr.indices) {
            val min = arr[i]
            var index = i
            for (j in i + 1 until arr.size) {
                if (arr[j] < min) {
                    index = j
                }
            }
            if (i != index) {
                val num = arr[i]
                arr[i] = arr[index]
                arr[index] = num
            }
        }
    }

    fun selectionSortComparator(arr: IntArray, comparator: Comparator<Int?>) {
        for (i in arr.indices) {
            val min = arr[i]
            var index = i
            for (j in i + 1 until arr.size) {
                if (comparator.compare(min, arr[j]) > 0) {
                    index = j
                }
            }
            if (i != index) {
                val num = arr[i]
                arr[i] = arr[index]
                arr[index] = num
            }
        }
    }

    /**
     * isOrder
     * Дан массив целых чисел. Определить, является ли он упорядоченным
     */
    fun isOrder(arr: IntArray): Boolean {
        return isOrderAscending(arr) || isOrderDescending(arr)
    }

    private fun isOrderAscending(arr: IntArray): Boolean {
        for (i in 0 until arr.size - 1) {
            if (arr[i] > arr[i + 1]) {
                return false
            }
        }
        return true
    }

    private fun isOrderDescending(arr: IntArray): Boolean {
        for (i in 0 until arr.size - 1) {
            if (arr[i] < arr[i + 1]) {
                return false
            }
        }
        return true
    }

    /**
     * towards
     * Дан массив вещественных чисел. Сформировать его строковое представление в формате JSON следующем порядке:
     * первое число, последнее, второе, предпоследнее и так далее все числа (см. пример).
     * Пример:
     * Входные данные:  1 2 3 4 5
     * Выходные данные:  [1, 5, 2, 4, 3]
     */
    fun towards(arr: IntArray): String {
        var str = ""
        var flag = false
        var i = 0
        var j = arr.size - 1
        while (i < arr.size / 2) {
            if (flag) str += ", "
            str += "" + arr[i] + ", " + arr[j]
            flag = true
            i++
            j--
        }
        if (arr.size % 2 != 0) {
            str += ", " + arr[arr.size / 2]
        }
        return "[$str]"
    }

    /**
     * Задача даны два двумерных массива - матрицы ,
     * выполнить произведение этих матриц алгебраически .
     * См произведение матриц
     */
    fun multipleMatrix(arr: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray>? {
        val arr1ColCount: Int = arr[0].size //количество столбцов в первой матрице
        val arr2RowCount = arr2.size //количество строк во второй матрице
        if (arr1ColCount != arr2RowCount) {
            return null
        }
        val arr1RowCount = arr.size //количество строк в первой матрице
        val arr2ColCount: Int = arr2[0].size //количество столбцов во второй матрице
        val arr3 = Array(arr1RowCount) {
            IntArray(
                arr2ColCount
            )
        }
        for (i in 0 until arr1RowCount) {
            for (j in 0 until arr2ColCount) {
                for (k in 0 until arr1ColCount) {
                    arr3[i][j] += arr[i][k] * arr2[k][j]
                }
            }
        }
        return arr3
    }

    /**
     * equalItems
     * Дан массив. Найдите элементы, равные друг другу.
     * Решение оформить 2 способами:
     * -использовать массив для хранения элементов(для определения количества равных использовать метод из задачи  23)
     * -использовать ArrayList для накопления элементов
     */
    //int[]arr={0,0,1,1,2,2,3,3,4,4};
    fun equalItems(arr: IntArray): IntArray {
        val equalItemsArr = IntArray(countEqualPairs(arr))
        var size = 0
        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                if (arr[i] == arr[j]) {
                    equalItemsArr[size] = arr[i]
                    size++
                }
            }
        }
        return equalItemsArr
    }

    fun equalItemsArrayList(arr: IntArray): ArrayList<Int> {
        val integerArrayList = ArrayList<Int>()
        val size = 0
        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                if (arr[i] == arr[j]) {
                    integerArrayList.add(arr[i])
                }
            }
        }
        return integerArrayList
    }

    /**
     * group
     * Дан массив строковых данных. Сформировать на основании данного массива новый массив,
     * элементами которого будут новые строки, скрепленные между собой по принципу их равности.
     * То есть необходимо реализовать алгоритм группировки строк по их равенству.
     * Пример:
     * Входные данные: [“aa”, “b”, “a”, “bb”, “aa”, “bb”]
     * Выходные данные: [“aa aa”, “b”, “a”, “bb bb”]
     * Указание:
     * Для сравнения строк использовать механизм str1.equals(str2). Оператор == для строк использовать нельзя
     * Решение оформить 2 способами:
     * -использовать массив для хранения элементов
     * -использовать ArrayList для накопления элементов
     */
    // a a a a a
    fun countEqualPairsString(arr: Array<String>): Int {
        var count = 0
        val booleans = BooleanArray(arr.size)
        for (i in arr.indices) {
            if (booleans[i] == true) {
                continue
            }
            for (j in i + 1 until arr.size) {
                if (arr[i] == arr[j] && i != j) {
                    booleans[j] = true
                    count++
                }
            }
        }
        return count
    }

    //[“aa”, “b”, “a”, “bb”, “aa”, “bb”]
    //[“aa aa”, “b”, “a”, “bb bb”]
    fun group(arr: Array<String>): Array<String?> {
        val groupArr = arrayOfNulls<String>(arr.size - countEqualPairsString(arr))
        val booleans = BooleanArray(arr.size)
        var size = 0
        for (i in arr.indices) {
            if (booleans[i]) {
                continue
            }
            var s = arr[i]
            for (j in i + 1 until arr.size) {
                if (arr[i] == arr[j]) {
                    booleans[j] = true
                    s += " " + arr[j]
                }
            }
            groupArr[size++] = s
        }
        return groupArr
    }

    /**
     * temperatureMinimum
     * Метеорологи ведут многолетние наблюдения за тем, в каком году была минимальная температура в данный день года.
     * Например, абсолютный минимум температуры в Москве 8 марта был -32 градуса (1890).
     * В течение k лет метеорологи вели наблюдения за n днями года.
     * Для каждого из этих n дней укажите минимальную температуру, которая была в этот день за k лет наблюдений.
     * Данные подаются в виде двумерного массива из k строк и n столбцов. Далее идет k строк, i-я строка содержит n чисел:
     * значения температур для n дней наблюдений i-го года.
     * Программа должна сформировать массив из n чисел: минимальное значение температуры для каждого из дней наблюдений.
     */
//    fun temperatureMinimum(arr: Array<IntArray>): IntArray {
//        val temperatureMinimumArr = IntArray(arr[0].size)
//        for (i in 0 until arr[i].size) {
//            var min = arr[0][i]
//            for (j in 1 until arr.size) {
//                if (arr[j][i] < min) {
//                    min = arr[j][i]
//                }
//            }
//            temperatureMinimumArr[i] = min
//        }
//        return temperatureMinimumArr
//    }

    fun setDiam(arr: Array<IntArray>): Double {
        var x: Int
        var y: Int
        var max = Double.MIN_VALUE
        for (i in arr.indices) {
            x = arr[i][0]
            y = arr[i][1]
            for (j in i + 1 until arr.size) {
                if (dist(x, y, arr[j][0], arr[j][1]) > max) {
                    max = dist(x, y, arr[j][0], arr[j][1])
                }
            }
        }
        return max
    }

    private fun dist(x1: Int, y1: Int, x2: Int, y2: Int): Double {
        return Math.sqrt(Math.pow((x2 - x1).toDouble(), 2.0) + Math.pow((y2 - y1).toDouble(), 2.0))
    }

    //        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {1, 2, 100}};
    //        int[] arr2 = {-103, 103, 0, -6, 6, 0, -9, 9};
    private fun debts(arr: Array<IntArray>, n: Int): IntArray {
        val balance = IntArray(n)
        for (i in arr.indices) {
            val index1 = arr[i][0] - 1
            val index2 = arr[i][1] - 1
            val sum = arr[i][2]
            balance[index1] -= sum
            balance[index2] += sum
        }
        return balance
    }
}