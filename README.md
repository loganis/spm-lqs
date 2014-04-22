# spm-lqs

* Scatter Plot Matrix for Loganis Query
* using Clojure, Incanter and clj-lqs

## Examples

### GA Session metrics by ga:deviceCategory

* ![SPM Session](https://raw.githubusercontent.com/loganis/spm-lqs/master/out/spm.png "Scatter Plot Matrix for Session metrics")
* Find PDF and SVG examples in your local `out` directory

### GA Adwords metrics by ga:campaign

* ![SPM Adwords](https://raw.githubusercontent.com/loganis/spm-lqs/master/out/spm2.png "Scatter Plot Matrix for Adwords metrics")
* Find PDF and SVG examples in your local `out` directory

## Usage

* Check out this project:

``` bash
git clone https://github.com/loganis/spm-lqs.git
```

* Generate a token on your Loganis Account
* Load `core.clj` and paste your token to

``` clojure
(def token "PUT_YOUR_TOKEN_STRING_HERE")
```

* Update channel names in `query` and `query2` definitions
* Load or Jack-in
* Results are saved to `out` directory
* Examine source code and update it to your needs

## License

Copyright © 2014 Loganis - iWebMa Ltd.

Distributed under the Eclipse Public License, the same as Clojure.
