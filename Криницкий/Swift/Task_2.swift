 
import Foundation

func ExtentInt(value: Int, extent: Int) -> Int {
    return Int(pow(Double(value), Double(extent)))
}

func ExtentDouble(value: Double, extent: Int) -> Double {
    return pow(value, 1.0 / Double(extent)) 
}

func chooseFunction(mathFunctionInt: (Int, Int) -> Int, mathFunctionDouble: (Double, Int) -> Double, a: Any, b: Any) -> Any? {
    if let intValue = a as? Int, let intExtent = b as? Int {
        return mathFunctionInt(intValue, intExtent)
    } else if let doubleValue = a as? Double, let intExtent = b as? Int {
        return mathFunctionDouble(doubleValue, intExtent)
    }
    return nil  
}

let result = chooseFunction(mathFunctionInt: ExtentInt, mathFunctionDouble: ExtentDouble, a: 0.81, b: 2) 

if let intResult = result as? Int {
    print("Результат для Int: \(intResult)")  
} else if let doubleResult = result as? Double {
    print("Результат для Double: \(doubleResult)")  
}