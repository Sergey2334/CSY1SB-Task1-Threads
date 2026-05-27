<img src="README_Images/TronBanner.webp" alt="TRON: The Neon Grid" style="border-radius: 20px; margin-bottom: 1rem;">

![Static Badge](https://img.shields.io/badge/TRON-Java_Swing-darkgreen)<space><space>
![Static Badge](https://img.shields.io/badge/%E2%AD%90%20%E2%AD%90%20%E2%AD%90%20%E2%AD%90%20%E2%AD%90-darkgreen?style=flat&logo=star&label=Ratings&labelColor=grey&color=darkgreen&link=https%3A%2F%2Fwww.merriam-webster.com%2Fdictionary%2Fnot%2520really)<space><space>
![Static Badge](https://img.shields.io/badge/10k-darkgreen?style=flat&logo=star&label=Daily%20Users&labelColor=grey&color=darkgreen&link=https%3A%2F%2Fwww.merriam-webster.com%2Fdictionary%2Fnot%2520really)

# Consumer Producer Simulation 🍊

## Hello, World :D
### 🔄 The Core Logic: Producer-Consumer Problem

At its heart, this simulation is a practical implementation of the classic **Producer-Consumer multi-threading problem**.

In this system, threads must cooperate safely without breaking or losing data:
*   **The Producers (Farmers):** These threads run in the background, harvesting 🍊 oranges and pushing them into the warehouse storage queue.
*   **The Buffer (Warehouse):** This acts as the shared memory space. It has a strict capacity limit, meaning farmers must wait if it fills up, and drivers must wait if it is empty.
*   **The Consumers (Drivers):** These threads continuously pull 🍊 oranges out of the warehouse to transport them away.

**Why this matters:** Without proper thread synchronization, the farmers and drivers would clash over the warehouse data at the exact same millisecond, causing data corruption, inventory miscounts, or application crashes.

To keep things stable and safe, this synchronization is handled directly within the supply chain management logic.

---
## 🚀 Simulation Features
*   **Warehouse Capacity:** Adjust the storage capacity up or down, or reset it back to default.
*   **Worker Management:** Add or remove workers, and change their work speed with a slider.
*   **Pause & Resume:** Freeze and continue the simulation logic. <small><kbd>WIP: Needs further testing</kbd></small>

---

## How to start?
Simply run the application from <code>Main</code> and you'll arrive at the Simulation <br>
press ![Static Badge](https://img.shields.io/badge/START_SIMULATION-cyan)<space><space> to start the Simulation


{Insert Simulation Picture Here}

### 🖥️ UI Layout & Controls
The interface is split into three simple columns, with the controls placed directly below their matching visual panels.

| Section | Left (Farmers) | Center (Warehouse) | Right (Drivers) |
| :--- | :--- | :--- | :--- |
| **Visuals & Stats** | • Worker status (active/idle)<br>• Live farmer stats | • Orange inventory flow<br>• Warehouse metrics | • Driver status (active/idle)<br>• Live driver stats |
| **Available Controls** | • Population (+ / -)<br>• Speed adjustment sliders | • Capacity (+1 / -1)<br>• Reset capacity button | • Start simulation<br>• Pause / Resume toggle |


<button style="background-color: green; color: white; padding: 5px 10px; border: none; border-radius: 4px; cursor: hand;">
    Hello
</button>

<kbd>Hello</kbd>

---
## How It Works ?


---

---
## Project Structure & Architecture
### 🏗️ How it's Built: The MVC Breakdown

This project is built using the **MVC (Model-View-Controller) pattern**. Instead of throwing all the code into one giant file, everything is split into three clean parts so it's easy to read, tweak, and upgrade.

*   **Model (The Brains):** This is where all the data lives and the actual logic happens. It tracks the simulation state, manages the workers, and knows what's going on behind the scenes—completely independent of how things look on screen.
*   **View (The Face):** This handles everything the user sees. It builds the windows, layouts, and panels (like your stats readouts and warehouse storage). It is purely visual and just waits for instructions on what data to display.
*   **Controller (The Link):** This sits right in the middle acting as the director. When a user clicks a button, drags a speed slider, or toggles pause, the Controller catches that input, tells the Model what to change, and ensures the View updates smoothly.



### 📁 Project Architecture
<details>
  <summary>📂 <b>Main</b></summary>
  <br>
  <ul>
    <li>📂 <b>java</b>
      <ul>
        <li>📂 <b>Root</b>
          <ul>
            <!-- CONTROLLER -->
            <li>
              <details>
                <summary>📂 <b>Controller</b></summary>
                <ul>
                  <li>📄 SimulationControls.java</li>
                  <li>📄 SupplyChainManager.java</li>
                  <li>📄 WorkerFactory.java (Interface)</li>
                  <li>📄 WorkerManager.java</li>
                </ul>
              </details>
            </li>
            <!-- CORE -->
            <li>
              <details>
                <summary>📂 <b>Core</b></summary>
                <ul>
                  <li>📄 Constants.java (Final)</li>
                  <li>📄 MyUtils.java (Final)</li>
                  <li>📄 WarehouseAction.java (Interface)</li>
                </ul>
              </details>
            </li>
            <!-- MODEL -->
            <li>
              <details>
                <summary>📂 <b>Model</b></summary>
                <ul>
                  <li>📄 Driver.java</li>
                  <li>📄 Farmer.java</li>
                  <li>📄 SimulationVisualManager.java</li>
                  <li>📄 Warehouse.java</li>
                  <li>📄 WarehouseManager.java</li>
                  <li>📄 Worker.java (Abstract)</li>
                </ul>
              </details>
            </li>
            <!-- VIEW -->
            <li>
              <details>
                <summary>📂 <b>View</b></summary>
                <ul>
                  <li>
                    <details>
                      <summary>📂 <b>MainWindow</b></summary>
                      <ul>
                        <li>📄 MainWindow.java</li>
                      </ul>
                    </details>
                  </li>
                  <li>
                    <details>
                      <summary>📂 <b>SimulationArea</b></summary>
                      <ul>
                        <li>📄 SimulationArea.java</li>
                        <li>
                          <details>
                            <summary>📂 <b>DriversPanel</b></summary>
                            <ul>
                              <li>📄 DriversPanel.java</li>
                              <li>📄 DriversStats.java</li>
                              <li>📄 DriversVisuals.java</li>
                            </ul>
                          </details>
                        </li>
                        <li>
                          <details>
                            <summary>📂 <b>FarmersPanel</b></summary>
                            <ul>
                              <li>📄 FarmersPanel.java</li>
                              <li>📄 FarmersStats.java</li>
                              <li>📄 FarmersVisuals.java</li>
                            </ul>
                          </details>
                        </li>
                        <li>
                          <details>
                            <summary>📂 <b>WarehousePanel</b></summary>
                            <ul>
                              <li>📄 WarehousePanel.java</li>
                              <li>📄 WarehouseStats.java</li>
                              <li>📄 WarehouseStorage.java</li>
                            </ul>
                          </details>
                        </li>
                      </ul>
                    </details>
                  </li>
                  <li>
                    <details>
                      <summary>📂 <b>SimulationControlsArea</b></summary>
                      <ul>
                        <li>📄 SimulationControlsArea.java</li>
                        <li>
                          <details>
                            <summary>📂 <b>AddSubResetArea</b></summary>
                            <ul>
                              <li>📄 AddSubResetPanel.java</li>
                            </ul>
                          </details>
                        </li>
                        <li>
                          <details>
                            <summary>📂 <b>ControlsUtils</b></summary>
                            <ul>
                              <li>📄 SimulationControlsButton.java</li>
                            </ul>
                          </details>
                        </li>
                        <li>
                          <details>
                            <summary>📂 <b>SlidersArea</b></summary>
                            <ul>
                              <li>📄 SliderPanel.java</li>
                              <li>📄 WorkerSpeedSlider.java</li>
                            </ul>
                          </details>
                        </li>
                        <li>
                          <details>
                            <summary>📂 <b>StartPauseResumeArea</b></summary>
                            <ul>
                              <li>📄 StartPauseResumePanel.java</li>
                            </ul>
                          </details>
                        </li>
                      </ul>
                    </details>
                  </li>
                  <li>
                    <details>
                      <summary>📂 <b>ViewUtils</b></summary>
                      <ul>
                        <li>📄 ViewUtils.java (Final)</li>
                      </ul>
                    </details>
                  </li>
                </ul>
              </details>
            </li>
          </ul>
        </li>
      </ul>
    </li>
    <br>
    <li><code>Main</code> <kbd>⬅️ Start Here :D</kbd></li>
  </ul>
</details>

---

## Goodbye World :D
The game is split into specialized "Managers" that handle different parts of the world, one for sounds, one for effects, and one for the game rules.
This makes the game run smoothly and makes it easy to add new features!

But* not gonna lie, there are a bunch of Bugs, That I wish I could fix, unfortunately I have no time :')
There are a bunch more of cool Features that I wanted to add, for example a Setting screen for button binding a Mute button, Splitting GameLauncher into more Managers like Collision, Paint, State Manager and much more.
But.. it is what it is :D

**Play games, make groups, meet new people, have fun and most importantly.. Enjoy :)**