# PThreads

## Nastavitve **attr** za izvedbo niti

* joinable_nit - lahko cakam da nit konca z delom predem nadaljujem z programom

## Identifikacija niti

* vsaka nit ob nastanku dobi ID
* ID lahko uporabimo tudi pri primerjanju niti

---

* Ce zelimo pocakat da nit zakljuci PTHREAD_EXIT(), ne zdruzimo rezultatov

## Zdruzevanje niti

* PTHREAD_JOIN
* caka na konec izvajanja niti in nato zdruzi rezultate
* ko niti koncajo dobimo "rezultate" in lahko nekaj z njimi naredimo (npr. izpisemo)

## Detached threads 

## Mehanizmi za sinhronizaciojo v PThreads

### 1. Mutex
* podatkovna struktura tipa **pthread_mutex_t**
* Ga naredimo in na koncu ga moremo **UNICIT** ce ne imamo memory leak
* mutex - kljucavnice, zagotvljajo medsebojno izzkljucevanje izvajanja KP
* Funkcije:
  * phread_mutex_init
  * phread_mutex_destroy
  * phread_mutex_lock
  * phread_mutex_trylock
  * phread_mutex_unlock

### 2. Pogojne spremenljivke

* uporabljamo vedno skupaj z mutex-i
* uporabimo za zaustavitev in ponovni zagon niti v kombinaciji z mutex-i => za pogojno sinhronizacijo
* Funkcije:
  * pthread_cond_init
  * pthread_cond_destroy
  * pthread_cond_wait - omogoca 2 operaciji na enkrat ... pogojna sinhronizacija
  * pthread_cond_signal
  * pthread_cond_broadcast