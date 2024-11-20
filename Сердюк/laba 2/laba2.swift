
func isPrime(_ num: Int) -> Bool {
    guard num > 1 else { return false }
    if num == 2 { return true }
    if num % 2 == 0 { return false }
    
    let maxDivisor = Int(Double(num).squareRoot())
    if maxDivisor < 3 {
        return true // 2 - единственное четное простое число
    }
    
    for i in 3...maxDivisor where i % 2 != 0 {
        if num % i == 0 {
            return false
        }
    }
    return true
}
 
// MARK: - Задание 1: Числа Мерсенна 
 
func findMersenneNumbers(lessThan n: Int) -> [Int] { 
    var mersenneNumbers: [Int] = [] 
    var p = 2 
    while true { 
        let mersenne = (1 << p) - 1  // 2^p - 1 
        if mersenne >= n { 
            break 
        } 
        if isPrime(p) && isPrime(mersenne) { 
            mersenneNumbers.append(mersenne) 
        } 
        p += 1 
    } 
    return mersenneNumbers 
} 
 
// MARK: - Задание 2: Обработка последовательности 
 
// Обрезка всех элементов после следующего четного числа 
func trimAfterNextEven(sequence: [Int]) -> [Int] { 
    guard !sequence.isEmpty, sequence.first! % 2 == 0 else { return sequence } 
    var result: [Int] = [] 
    var evenFound = false 
    for number in sequence { 
        result.append(number) 
        if number % 2 == 0 { 
            if evenFound { 
                break 
            } 
            evenFound = true 
        } 
    } 
    return result 
} 
 
// Обрезка всех элементов, начиная с 4-го после первого нечетного числа 
func trimFromFourthAfterOdd(sequence: [Int]) -> [Int] { 
    guard !sequence.isEmpty, sequence.first! % 2 != 0 else { return sequence } 
    var countAfterOdd = 0 
    var indexToTrim: Int? = nil 
     
    for (index, number) in sequence.enumerated() { 
        if index == 0 && number % 2 != 0 { 
            continue 
        } 
        if countAfterOdd >= 4 { 
            indexToTrim = index 
            break 
        } 
        countAfterOdd += 1 
    } 
     
    if let trimIndex = indexToTrim { 
        return Array(sequence.prefix(trimIndex)) 
    } 
    return sequence 
} 
 
// MARK: - Основная программа 
 
// Значения для n и последовательности задаем сразу 
let n = 12 
let sequence = [1, 2, 3, 4, 5, 6, 7, 8, 9] 
 
// Проверка на корректность значения n 
if n <= 0 { 
    print("Ошибка: n должно быть натуральным числом.") 
} else { 
    // Задание 1: Найти числа Мерсенна 
    let mersenneNumbers = findMersenneNumbers(lessThan: n) 
    print("Числа Мерсенна меньше \(n): \(mersenneNumbers)") 
} 
 
// Задание 2: Обработка последовательности 
if sequence.isEmpty { 
    print("Ошибка: последовательность не должна быть пустой и должна содержать только целые числа.") 
} else { 
    // Обработка последовательности 
    if let first = sequence.first { 
        if first % 2 == 0 { 
            let trimmed = trimAfterNextEven(sequence: sequence) 
            print("Обрезанная последовательность (после следующего четного): \(trimmed)") 
        } else { 
            let trimmed = trimFromFourthAfterOdd(sequence: sequence) 
            print("Обрезанная последовательность (с 4-го после нечетного): \(trimmed)") 
        } 
    } 
}
