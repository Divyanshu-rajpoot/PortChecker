# 🔧 Port Checker CLI Tool

A simple Java-based command-line tool to check and kill processes running on specific ports. 
Useful for developers who frequently run into port conflicts while working on web servers, microservices, or development environments.

---

## ✨ Features

- 🔍 **Check** if a specific port is in use
- ✅ **List** all ports currently in use
- 💀 **Kill** processes occupying a specific port (Windows, macOS, Linux)
- 🎨 Clean and colorful terminal output
- 🧪 Lightweight, no external dependencies
- 🪄 Cross-platform support

---

## 📦 Download

👉 Go to the [Releases](https://github.com/Divyanshu-rajpoot/PortChecker/releases/) section and download the latest `port-checker.jar` file.

---

## 🚀 Usage

### ✅ Check if a port is in use

```bash
java -jar port-checker.jar --check 8080
```

### ✅ Kill a port based on the number

```
java -jar port-checker.jar --kill 3000
```

### ✅ List all the ports that are Listening or Up

```
java -jar port-checker.jar --list
```
### ✅ Get all the help
```
java -jar port-checker.jar --help
```
