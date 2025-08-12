# HMCTS Developer Challenge – Task Manager

Spring Boot solution for the HMCTS Developer Challenge.  
This application provides a simple Task Manager API where you can create, read, update, and delete tasks.

---

## Prerequisites
- **Java 17** installed
- **(Optional)** Maven installed — not required if you use the included Maven Wrapper (`mvnw` / `mvnw.cmd`)

---

## How to Run

### **Option 1: IntelliJ IDEA (easiest)**
1. Open `TaskmanagerApplication.java` in IntelliJ.
2. Click the green ▶ icon next to the `main` method and select **Run 'TaskmanagerApplication'**.
3. Once started, open your browser and go to:  
   [http://localhost:8080](http://localhost:8080)

---

### Option 2: Terminal

#### macOS / Linux
```bash
./mvnw clean install
./mvnw spring-boot:run

```


### Windows
```bash
mvnw.cmd clean install
mvnw.cmd spring-boot:run

```

---

## API Endpoints
Base URL: `http://localhost:8080`

- `GET /tasks` – get all tasks
- `GET /tasks/{id}` – get a task by ID
- `POST /tasks` – create a new task
- `PUT /tasks/{id}` – update a task
- `DELETE /tasks/{id}` – delete a task

### Example JSON
**Create/Update body**
```json
{
  "title": "Buy milk",
  "completed": false
}
```
## Quick curl tests


**list tasks**
```
curl http://localhost:8080/tasks
```

**get one**
```
curl http://localhost:8080/tasks/1
```

**create**
```
curl -X POST http://localhost:8080/tasks \
-H "Content-Type: application/json" \
-d '{"title":"Buy milk","completed":false}'
```

**update**
```
curl -X PUT http://localhost:8080/tasks/1 \
-H "Content-Type: application/json" \
-d '{"title":"Buy bread","completed":true}'
```

**delete**
```
curl -X DELETE http://localhost:8080/tasks/1
```
## Testing

### From IntelliJ
Right-click the `test` folder and select **Run 'All Tests'**.

### From Terminal (macOS / Linux)
```bash
./mvnw test
```

### From Terminal (Windows)
```bat
mvnw.cmd test
```

### Author 
**Shelina Begum**
