# spm-lqs

* Scatter Plot Matrix for Loganis Query
* using Clojure, Incanter and clj-lqs

## Examples

### GA Session metrics by ga:deviceCategory

### GA Adwords metrics by ga:campaign

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

## License

Copyright © 2014 Loganis - iWebMa Ltd.

Distributed under the Eclipse Public License, the same as Clojure.
