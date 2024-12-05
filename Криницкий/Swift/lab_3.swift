import Foundation

class Transport {
    var xTower: Double
    var yTower: Double
    var Direction: Double

    init(xTower: Double, yTower: Double, Direction: Double) {
        self.xTower = xTower
        self.yTower = yTower
        self.Direction = Direction
    }
}


class Car: Transport {
    let numberCar: String
    var music: Bool
    var Path: Double

    init(numberCar: String, music: Bool, xTower: Double, yTower: Double, Direction: Double, Path: Double = 0.0) {
        self.numberCar = numberCar
        self.music = music
        self.Path = Path
        super.init(xTower: xTower, yTower: yTower, Direction: Direction)
    }

    func MoveCar(distance: Double) {
        Path += distance
        var x: Double = xTower
        var y: Double = yTower
        let b: Double = yTower - xTower * tan(Direction * .pi / 180)
        
        let step: Double = (Direction >= -90 && Direction <= 90) ? 1.0 : -1.0

        while (pow(x - xTower, 2) + pow(y - yTower, 2) <= pow(distance, 2)) {
            print("Положение по координате x: \(x)\tПоложение по координате y: \(y)")
            x += step
            y = x * tan(Direction * .pi / 180) + b
        }
         print("Пройденный путь: \(Path)")
        xTower = x
        yTower = y
    }

    func turn(to newDirection: Double) {
        Direction = newDirection
        print("Автомобиль повернул в новое направление: \(Direction)°")
    }
}


class Bus: Car {
    var Amount_of_passengers: Int = 0
    let Money_for_trip: Double = 0.90
    var Total_money: Double = 0     //общая сумма денег (например, за день)
    var Total_passengers: Int = 0  //общая сумма пассажиров (например, за день)

    override init(numberCar: String, music: Bool, xTower: Double, yTower: Double, Direction: Double, Path: Double = 0.0) {
        super.init(numberCar: numberCar, music: music, xTower: xTower, yTower: yTower, Direction: Direction, Path: Path)
    }

    func Enter() {
        Amount_of_passengers += 1
        Total_passengers += 1
        print("Количество пассажиров: \(Amount_of_passengers)")
    }

    func Go_out() {
        if Amount_of_passengers > 1 {
            Amount_of_passengers -= 1
            print("Количество пассажиров: \(Amount_of_passengers)")
        } else {
            print("Пассажиров нет")
        }
    }

    func Move() {
        Total_money = Money_for_trip * Double(Total_passengers)*Path
        print("Общая сумма денег: \(Total_money)")
    }
}

let car1 = Car(numberCar: "1234", music: true, xTower: 2, yTower: 1, Direction: 45)
car1.MoveCar(distance: 10.0)
car1.turn(to: 225)
car1.MoveCar(distance: 10.0)



let bus1 = Bus(numberCar: "1234bus", music: false, xTower: 7, yTower: 3, Direction: 30)
for _ in 0..<3 {
    bus1.Enter()
}
bus1.MoveCar(distance: 20.0)
bus1.Move()
bus1.Go_out()
bus1.Go_out()
bus1.Go_out()
bus1.Move()