import Foundation

func generateRandomNumber(min: Int, max: Int) -> Int {
    let randomSeed = Int(Date().timeIntervalSince1970 * 1000) % (max - min + 1)
    return min + randomSeed
}

protocol UniqueNumberGenerator {
    func generateUniqueNumber() -> Int
}


class RandomNumberGenerator: UniqueNumberGenerator {
    private var generatedNumbers: Set<Int> = []
    private let min: Int = 1
    private let max: Int = 1000

    func generateUniqueNumber() -> Int {
        var uniqueNumber: Int
        
        repeat {
            uniqueNumber = generateRandomNumber(min: min, max: max)
        } while generatedNumbers.contains(uniqueNumber)
        
        generatedNumbers.insert(uniqueNumber)
        return uniqueNumber
    }
}


class SequentialNumberGenerator: UniqueNumberGenerator {
    private var currentNumber: Int = 0
    
    func generateUniqueNumber() -> Int {
        currentNumber += 1
        return currentNumber
    }
}


class FibonacciNumberGenerator: UniqueNumberGenerator {
    private var previous: Int = 0
    private var current: Int = 1
    
    func generateUniqueNumber() -> Int {
        let nextNumber = previous + current
        previous = current
        current = nextNumber
        return nextNumber
    }
}


class UniqueNumberGeneratorClient {
    private var generator: UniqueNumberGenerator
    
    init(generator: UniqueNumberGenerator) {
        self.generator = generator
    }
    
    func generateUniqueNumbers(count: Int) -> [Int] {
         guard count > 0 else {
            fatalError("count должен быть больше 0")
        }
        var uniqueNumbers: Set<Int> = []
        
        while uniqueNumbers.count < count {
            let number = generator.generateUniqueNumber()
            uniqueNumbers.insert(number)
        }
        
        return Array(uniqueNumbers)
    }
}



let randomGenerator = RandomNumberGenerator()
let randomClient = UniqueNumberGeneratorClient(generator: randomGenerator)
let randomUniqueNumbers = randomClient.generateUniqueNumbers(count: 5)
print("Случайные уникальные числа: \(randomUniqueNumbers)")

let sequentialGenerator = SequentialNumberGenerator()
let sequentialClient = UniqueNumberGeneratorClient(generator: sequentialGenerator)
let sequentialUniqueNumbers = sequentialClient.generateUniqueNumbers(count: 5)
print("Последовательные уникальные числа: \(sequentialUniqueNumbers)")

let fibonacciGenerator = FibonacciNumberGenerator()
let fibonacciClient = UniqueNumberGeneratorClient(generator: fibonacciGenerator)
let fibonacciUniqueNumbers = fibonacciClient.generateUniqueNumbers(count: 5)
print("Числа Фибоначчи: \(fibonacciUniqueNumbers)")