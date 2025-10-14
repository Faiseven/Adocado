# 💜 AdoApp

Hi! This is a **Java Swing** application that uses **JSON** to load songs and **FlatLaf** for the **FlatDark theme**.

---

## ⚡ Requirements

- **Java 17+**  
- **IntelliJ IDEA** (without Maven or Gradle)  
- **JAR files** (placed in the `lib` folder):  
  - **Jackson**:
    - `jackson-databind-2.16.0.jar`
    - `jackson-core-2.16.0.jar`
    - `jackson-annotations-2.16.0.jar`
  - **FlatLaf**:
    - `flatlaf-3.1.1.jar`

---

## 🛠 Project Setup in IntelliJ

### 🟣 1️⃣ Add JARs to the project

1. Open your project in IntelliJ.  
2. Go to **File → Project Structure → Modules → Dependencies**.  
3. Click **+ → JARs or directories**.  
4. Select all the JARs in the `lib` folder.  
5. Set the scope to **Compile** and apply.

---

### 🟣 2️⃣ Configure the resources folder

1. Right-click on the `resources` folder inside `src/ado_app`.  
2. Choose **Mark Directory as → Resources Root**.  
   - If this option is not available, make sure the folder is inside the module.  
3. Rebuild the project (**Build → Rebuild Project**).  
4. You can add more songs to the JSON file.

---

### 🎵 Notes

- You can add songs to the JSON file in `resources/songs.json`.  
- The theme is **FlatDark**, giving a modern dark UI.  

---

<p align="right">
  <img src="https://i.scdn.co/image/ab67616d0000b2739f2bf548265df4b24efb1625" alt="Space Album" width="30"/>
</p>



