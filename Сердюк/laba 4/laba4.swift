
// Протокол для выполнения математических операций
protocol MathOperations {
    associatedtype Number
    func add(_ a: Number, _ b: Number) -> Number
    func subtract(_ a: Number, _ b: Number) -> Number
    func multiply(_ a: Number, _ b: Number) -> Number
    func divide(_ a: Number, _ b: Number) -> Number
    func power(_ base: Number, _ exponent: Int) -> Number
}

// Реализация для целых чисел
struct IntMathOperations: MathOperations {
    func add(_ a: Int, _ b: Int) -> Int {
        return a + b
    }

    func subtract(_ a: Int, _ b: Int) -> Int {
        return a - b
    }

    func multiply(_ a: Int, _ b: Int) -> Int {
        return a * b
    }

    func divide(_ a: Int, _ b: Int) -> Int {
        guard b != 0 else {
            fatalError("Division by zero is not allowed")
        }
        return a / b
    }

    func power(_ base: Int, _ exponent: Int) -> Int {
        guard exponent >= 0 else {
            fatalError("Exponent must be non-negative")
        }
        var result = 1
        for _ in 0..<exponent {
            result *= base
        }
        return result
    }
}

// Реализация для чисел с плавающей точкой
struct DoubleMathOperations: MathOperations {
    func add(_ a: Double, _ b: Double) -> Double {
        return a + b
    }

    func subtract(_ a: Double, _ b: Double) -> Double {
        return a - b
    }

    func multiply(_ a: Double, _ b: Double) -> Double {
        return a * b
    }

    func divide(_ a: Double, _ b: Double) -> Double {
        guard b != 0 else {
            fatalError("Division by zero is not allowed")
        }
        return a / b
    }

    func power(_ base: Double, _ exponent: Int) -> Double {
        guard exponent >= 0 else {
            fatalError("Exponent must be non-negative")
        }
        var result: Double = 1.0
        for _ in 0..<exponent {
            result *= base
        }
        return result
    }
}

// Пример использования
let intOps = IntMathOperations()
print("Сложение: \(intOps.add(3, 5))") // 8
print("Вычитание: \(intOps.subtract(10, 7))") // 3
print("Умножение: \(intOps.multiply(4, 6))") // 24
print("Деление: \(intOps.divide(20, 4))") // 5
print("Возведение в степень: \(intOps.power(2, 3))") // 8

let doubleOps = DoubleMathOperations()
print("Сложение: \(doubleOps.add(3.5, 5.2))") // 8.7
print("Вычитание: \(doubleOps.subtract(10.5, 7.3))") // 3.2
print("Умножение: \(doubleOps.multiply(4.2, 6.1))") // 25.62
print("Деление: \(doubleOps.divide(20.4, 4.0))") // 5.1
print("Возведение в степень: \(doubleOps.power(2.5, 3))") // 15.625