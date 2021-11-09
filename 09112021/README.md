# Semaforji

* P  ... zaklepanje
* V  ... naslednji korak, odklepanje

* sem s;    semafor, ki se klice s

* **P(s) = <await(s>0) s-->** atomarna operacija
* **V(s) = <s++>** atomarna opercaija

* problem 5ih filozofov

---

    Sem[] forks = {1,1,1,1,1};
    Process Philo [0...4]
    while(true){
        P(forks[i - 1], forks[i]);
        eat();
        V(forks[i - 1], forks[i]);
    }

    Process Philo[i] {
        while(true) {
            P(forks[0], forks[i]);
            eat();
            V(forks[0], forks[i]);
        }
    }

---

    forks[i] -> leva

    forks[i-1] -> desna

---

    int x = 0;
    sem s1=0;
    sem s2=1;
    
    co P(s2) x = x*2 V(s1)          -> proces A
    || P(s1) x = x+x V(s1)          -> proces B
    || P(s1) x = x+3; V(s2) V(s1);  -> proces C
    oc 

---

* mozni poteki processov:
<br>
    1) A B C : x = 3
    <br>
       A C B : x = 9