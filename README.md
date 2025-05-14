# 🐦 DoDo

**DoDo** — это минималистичное Android-приложение, разработанное с использованием **Jetpack Compose** и архитектуры **MVVM**. Оно создано в учебных целях для демонстрации современных подходов к созданию мобильных приложений на Kotlin.

---

## ✨ Особенности

- 🧱 **Jetpack Compose** — декларативный UI-фреймворк от Google  
- 🧠 **Архитектура MVVM** — четкое разделение логики UI и бизнес-логики  
- ⚙️ **Kotlin DSL** — конфигурация проекта через Kotlin-скрипты  
- 🎨 **Минималистичный дизайн** — чистый и современный интерфейс  

---

## 📸 Скриншоты

<!-- Замените URL на реальные изображения из проекта -->
<p align="center">
  <img src="https://github.com/nighbee/DoDo_LAB/assets/95701510/82f0a6ca-42dd-46d5-a56b-bb415e6f6c80" alt="Search Screen" width="250"/>
  <img src="https://github.com/nighbee/DoDo_LAB/assets/95701510/8b6f3e59-2a84-47f1-b7bf-b058c455efd8" alt="Main Screen" width="250"/>
  <img src="https://github.com/nighbee/DoDo_LAB/assets/95701510/831ca66a-4083-4885-87be-853cc7c920fa" alt="Detailed Task View" width="250"/>
  <img src="https://github.com/nighbee/DoDo_LAB/assets/95701510/91b32874-cffc-44d8-8c99-b51dde4fd13b" alt="Combo View" width="250"/>
</p>



---

## 🚀 Технологии

- **Язык**: Kotlin  
- **UI**: Jetpack Compose  
- **Архитектура**: MVVM  
- **Навигация**: Jetpack Navigation Compose  
- **Build-система**: Gradle с Kotlin DSL  
- **Прочее**:
  - ViewModel & State Management
  - Material Design 3

---

## 📦 Установка

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/nighbee/DoDo.git
   cd DoDo
Откройте проект в Android Studio (желательно Arctic Fox или выше)

Синхронизируйте Gradle и запустите приложение на эмуляторе или устройстве.

📁 Структура проекта
bash
Копировать
Редактировать
DoDo/
├── app/               # Исходный код приложения
│   └── src/
│       ├── main/
│       │   ├── ui/    # UI-компоненты на Jetpack Compose
│       │   ├── viewmodel/
│       │   └── model/
├── build.gradle.kts   # Конфигурация Gradle (Kotlin DSL)
├── settings.gradle.kts
└── images/            # Ресурсы проекта


