# 🎓 Java Learning Project

## 📝 Описание проекта
Этот проект представляет собой коллекцию примеров и упражнений по изучению Java. Здесь вы найдете базовые концепции программирования, реализованные на Java, а также примеры интеграции с другими языками программирования, такими как Lua.

## 🚀 Особенности
- ✨ Современный графический интерфейс
- 🎨 Стильный дизайн в духе macOS
- 🔄 Интеграция с Lua
- 📊 Примеры базовых вычислений
- 🎯 Интерактивные элементы управления

## 📦 Структура проекта
```
JavaLearning/
├── src/
│   ├── HelloWorld.java    # Основной файл с GUI
│   └── JavaSyntax.java    # Примеры синтаксиса Java
└── README.md             # Документация проекта
```

## 💻 Примеры кода

### Java
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Привет, мир!");
    }
}
```

### Lua
```lua
-- Пример интеграции Lua с Java
function greet(name)
    return "Привет, " .. name .. "!"
end

-- Пример работы с таблицами
local config = {
    window = {
        width = 500,
        height = 400,
        title = "Java Learning"
    },
    theme = {
        primary = "#1E1E1E",
        secondary = "#2D2D2D",
        accent = "#007ACC"
    }
}

-- Пример функции для работы с GUI
function createWindow()
    local window = {
        title = config.window.title,
        size = {
            width = config.window.width,
            height = config.window.height
        },
        theme = config.theme
    }
    return window
end
```

## 🛠️ Требования
- Java Development Kit (JDK) 17 или выше
- Lua 5.4 или выше
- IDE с поддержкой Java (рекомендуется IntelliJ IDEA или VS Code)

## 📚 Документация
### Основные концепции
1. **Графический интерфейс**
   - Создание окон
   - Работа с компонентами
   - Стилизация элементов

2. **Интеграция с Lua**
   - Вызов Lua скриптов из Java
   - Передача данных между языками
   - Обработка результатов

3. **Стилизация**
   - Поддержка темной темы
   - Эффект матового стекла
   - Адаптивный дизайн

## 👥 Авторы
- Спивак И.В. - Основной разработчик

## 📞 Контакты
- Email: st.remedy@icloud.com 
- GitHub: https://github.com/densecloudss

---
⭐ Не забудьте поставить звезду проекту, если он вам понравился! 