# facet-photo

An example application which demonstrates taking photos using Sony Remote Camera Control API Beta.

This example uses [facet](https://github.com/hammartap/facet) for taking and retrieve images from Sony camera, and [Quil](https://github.com/quil/quil) for visualisation.

## Usage
1. Make sure your machine is connected Sony Camera via WiFi.
2. Clone this repository, then fire up REPL.
3. Import the library and execute `(-main)`

```
$ git clone https://github.com/hammartap/facet-photo.git
$ cd facet-photo
$ lein repl
```

```clojure
;; Change namespace.
;; This is optional. But it is helpful when playing with this library.
(ns facet-liveview.core)

;; Import a library.
(use 'facet-photo.core)

;; Then, call main function.
(-main)

;; Take a picture.
(shutter!)

;; Finish the window.
(close)
```

## License

Copyright © 2014 hammartap

Distributed under the Eclipse Public License, the same as Clojure.
