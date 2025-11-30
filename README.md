# 🚀 Secure Online Judge — 安全高性能在线代码判题系统

> **从 0 到 1 构建的 Java 在线判题系统，集成原生沙箱 + Docker 沙箱 + 多策略判题框架 + 安全管控体系。  
> 专为应对恶意代码攻击、资源滥用、沙箱逃逸、系统调用滥用等安全问题而设计。**

<p align="center">
🔥 多层防御  | ⚙️ 高扩展性  | 🧩 插件化判题策略  | 🐳 Docker 隔离 | ☢️ Seccomp 系统调用过滤
</p>

---

## ✨ 项目特性

- **双沙箱体系：原生沙箱 + Docker 沙箱**
- **内建安全防护：Seccomp / Cgroups / SecurityManager / 黑名单字典树**
- **策略模式判题：严格匹配 / 范围判定 / 自定义策略**
- **静态工厂模式创建沙箱实例，可动态切换执行环境**
- **代理模式提供日志增强、监控、统计等 AOP 能力**
- **模板方法抽象统一执行流程（保存 → 编译 → 执行 → 收集 → 清理）**

---

## 📘 项目背景

在线判题系统需执行用户提交的任意代码，必须防御以下风险：

- 恶意文件读写与敏感系统调用
- 无限循环、fork 炸弹、内存爆炸
- 沙箱逃逸
- CPU / 内存 / IO 滥用
- 多用户并发下的高可用调度

本项目从零设计了一个安全、可扩展、可维护的判题系统。

---

## 🔒 安全设计

### 1. 原生 Java 沙箱（Native Sandbox）

✔ 运行时隔离
- `Runtime.exec()` 创建受控子进程  
- `Thread.sleep + destroy()` 实现超时终止  
- JVM 参数 `-Xmx` 限制内存  

✔ 敏感操作拦截（SecurityManager）
- 文件读写：拦截 `FilePermission`  
- 进程创建：拦截 `RuntimePermission`  
- 网络访问：拦截 `SocketPermission`  

✔ 字典树 + 黑名单检测
- 禁止反射  
- 禁止创建进程  
- 禁止 System.exit  
- 禁止加载本地库  
- 禁止访问文件系统 API  

### 2. Docker 沙箱（Docker Sandbox）

使用 `docker-java` SDK 完全隔离用户代码。

✔ 容器资源限制（HostConfig）
- 内存限制：`withMemory(100MB)`  
- 禁用 Swap：`withMemorySwap(0)`  
- CPU 限制：`withCpuCount(1)`  
- 只读根目录：readonly rootfs  
- 挂载代码目录为只读  

✔ Linux 内核安全模块

🔧 Seccomp
限制系统调用：

- 禁止 `clone`（禁止 fork）
- 禁止 `write`（限制写文件）
- 禁止 `unshare` / `mount`（阻止逃逸）

🔧 Cgroups  
限制 CPU / 内存 / IO 资源。


### 3. 日志捕获与调度控制

- `ExecStartResultCallback` 异步流式捕获 stdout & stderr  
- `CountDownLatch` 实现超时控制  
- 自动拼接用户输出  
- 执行完毕后自动文件清理  

---

## 🧩 判题策略（Strategy Pattern）

内置可选：

- **StrictJudgeStrategy**：严格相等  
- **RangeJudgeStrategy**：误差范围  
- **LineByLineStrategy**：逐行比较  
- **自定义策略**（扩展 JudgeStrategy 接口）  

无需修改判题主流程即可添加新策略。

---

## 🏭 沙箱创建（Static Factory Pattern）

统一沙箱接口：

```java
public interface CodeSandbox {
    ExecuteResult execute(CodeRequest request);
}
```

工厂提供：
- NativeSandbox
- DockerSandbox
可轻松扩展 Firecracker、gVisor、eBPF 等未来沙箱。

## 🔍 核心能力总结
✅ 从 0 到 1 自研原生 Java 沙箱
- Runtime.exec
- Process I/O
- 守护线程终止超时任务
- `-Xmx` 控制内存

✅ 多层防御安全体系
- SecurityManager
- 黑白名单 + 字典树
- 系统调用限制

✅ 完整 Docker 沙箱实现
- Docker Java SDK
- seccomp
- cgroups
- HostConfig 隔离资源

🛠 架构层设计模式全面应用
- 静态工厂模式
- 策略模式
- 代理模式
- 模板方法模式

## ⭐ Star 本项目

如果你觉得本项目对你有帮助，请点个 Star ⭐！

你的支持是我持续迭代的动力！

注：该项目来源于[编程导航知识星球](https://yupi.icu)，感谢[yupi](https://github.com/liyupi)大佬