class Employee {
    var name: String
    var position: String
    var experience: Int

    // Инициализатор для задания имени, должности и стажа
    init(name: String, position: String, experience: Int) {
        self.name = name
        self.position = position
        self.experience = experience
    }

    // Метод для вывода информации о сотруднике
    func printInfo() {
        print("Имя: \(name)\nДолжность: \(position)\nСтаж: \(experience)\(formatYears(experience))\n")
    }

    // Приватный метод для правильного склонения слова "год"
    private func formatYears(_ years: Int) -> String {
        let lastDigit = years % 10
        let secondLastDigit = (years / 10) % 10

        if secondLastDigit == 1 {
            return "лет"
        }

        switch lastDigit {
        case 1:
            return "год"
        case 2, 3, 4:
            return "года"
        default:
            return "лет"
        }
    }
}

// Пример использования
let employee1 = Employee(name: "Василий", position: "Системный администратор", experience: 3)
employee1.printInfo()

let employee2 = Employee(name: "Анна", position: "Менеджер", experience: 11)
employee2.printInfo()

let employee3 = Employee(name: "Игорь", position: "Дизайнер", experience: 21)
employee3.printInfo()