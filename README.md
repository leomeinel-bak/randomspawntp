<!-- PROJECT SHIELDS -->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![Quality][quality-shield]][quality-url]

<!-- PROJECT LOGO -->
<!--suppress ALL -->
<br />
<p align="center">
  <a href="https://github.com/TamrielNetwork/RandomSpawnTp">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

<h3 align="center">RandomSpawnTp</h3>

  <p align="center">
    Spectate Players on Spigot and Paper
    <br />
    <a href="https://github.com/TamrielNetwork/RandomSpawnTp"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/TamrielNetwork/RandomSpawnTp">View Demo</a>
    ·
    <a href="https://github.com/TamrielNetwork/RandomSpawnTp/issues">Report Bug</a>
    ·
    <a href="https://github.com/TamrielNetwork/RandomSpawnTp/issues">Request Feature</a>
  </p>

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary><h2 style="display: inline-block">Table of Contents</h2></summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#description">Description</a></li>
        <li><a href="#features">Features</a></li>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#commands-and-permissions">Commands and Permissions</a></li>
        <li><a href="#configuration">Configuration</a></li>
      </ul>
    </li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>

<!-- ABOUT THE PROJECT -->

## About The Project

### Description

RandomSpawnTp is a Random Spawn Teleport Plugin.

This plugin is perfect for any server wanting their players to teleport to random world spawns.

### Features

* Teleport players to a random world spawn
* Configure a list of worlds to be included

### Built With

* [Gradle 7](https://docs.gradle.org/7.3.3/release-notes.html)
* [OpenJDK 17](https://openjdk.java.net/projects/jdk/17/)

<!-- GETTING STARTED -->

## Getting Started

To get the plugin running on your server follow these simple steps.

### Commands and Permissions

1. Permission: `randomspawntp.teleport`

* Command: `/randomspawntp`
* Description: Teleport to a random world spawn

### Configuration - config.yml

```
worlds:
  - 'world_the_end_0'
  - 'world_the_end_1'
  - 'world_the_end_2'
  - 'world_the_end_3'
  - 'world_the_end_4'
  - 'world_the_end_5'
  - 'world_the_end_6'
  - 'world_the_end_7'
  - 'world_the_end_8'
  - 'world_the_end_9'
  - 'world_the_end_10'
  - 'world_the_end_11'
  - 'world_the_end_12'
  - 'world_the_end_13'
  - 'world_the_end_14'
  - 'world_the_end_15'
  - 'world_the_end_16'
  - 'world_the_end_17'
  - 'world_the_end_18'
  - 'world_the_end_19'
  - 'world_the_end_20'
  - 'world_the_end_21'
  - 'world_the_end_22'
  - 'world_the_end_23'
  - 'world_the_end_24'
```

### Configuration - messages.yml

```
player-only: "&cThis command can only be executed by players!"
invalid-option: "&cInvalid option!"
no-perms: "&7You don't have enough permissions!"
```

<!-- ROADMAP -->

## Roadmap

See the [open issues](https://github.com/TamrielNetwork/RandomSpawnTp/issues) for a list of proposed features (and known
issues).

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to be, learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<!-- LICENSE -->

## License

Distributed under the GNU General Public License v3.0. See `LICENSE` for more information.

<!-- CONTACT -->

## Contact

Leopold Meinel - [@TamrielN](https://twitter.com/TamrielN) - Twitter

Leopold Meinel - [contact@tamriel.me](mailto:contact@tamriel.me) - eMail

Project Link - [RandomSpawnTp](https://github.com/TamrielNetwork/RandomSpawnTp) - GitHub

<!-- ACKNOWLEDGEMENTS -->

### Acknowledgements

* [README.md - othneildrew](https://github.com/othneildrew/Best-README-Template)

<!-- MARKDOWN LINKS & IMAGES -->

[contributors-shield]: https://img.shields.io/github/contributors-anon/TamrielNetwork/RandomSpawnTp?style=for-the-badge

[contributors-url]: https://github.com/TamrielNetwork/RandomSpawnTp/graphs/contributors

[forks-shield]: https://img.shields.io/github/forks/TamrielNetwork/RandomSpawnTp?label=Forks&style=for-the-badge

[forks-url]: https://github.com/TamrielNetwork/RandomSpawnTp/network/members

[stars-shield]: https://img.shields.io/github/stars/TamrielNetwork/RandomSpawnTp?style=for-the-badge

[stars-url]: https://github.com/TamrielNetwork/RandomSpawnTp/stargazers

[issues-shield]: https://img.shields.io/github/issues/TamrielNetwork/RandomSpawnTp?style=for-the-badge

[issues-url]: https://github.com/TamrielNetwork/RandomSpawnTp/issues

[license-shield]: https://img.shields.io/github/license/TamrielNetwork/RandomSpawnTp?style=for-the-badge

[license-url]: https://github.com/TamrielNetwork/RandomSpawnTp/blob/main/LICENSE

[quality-shield]: https://img.shields.io/codefactor/grade/github/TamrielNetwork/RandomSpawnTp?style=for-the-badge

[quality-url]: https://www.codefactor.io/repository/github/TamrielNetwork/RandomSpawnTp
