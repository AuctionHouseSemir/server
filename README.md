### Architecture, packages guideline

* **auction/, auth/**
  * most inner circle
  * business logic
  * knows absolutely nothing about any other component 
  * can be used in different use cases

* **commands/**
  * middle circle
  * use case
  * knows about most inner circle, but knows nothing about anything else 
  * we can change from grpc to something else and still re-use commands/ package

* **infrastructure/, service/**
  * most outer circle
  * unimportant implementation detail
  * knows about other components
  * can be replaced, no other component will be affected at all


- dependency always points inward
- inner circle knows nothing about outer world


#### Commands
* Command
  * most important unit in commands/ package
  * use case
  * not really useful on its own, uses most inner circle to successfully accomplish some business logic
* CommandController
  * exposes and controls Commands
  * map command name from request to specific Command
  * execute Command
* CommandFactory
  * abstract Command creation
  * library to help us create Commands, basic setup and initializations


#### TODO
- [ ] better validation and error handling
- [ ] clean CommandFactory
- [ ] separate entities from dtos and implement mapping between these
- [ ] CacheStorage should be thread-safe
- [ ] use JWT for authentication
- [ ] write unit tests and then implement all the functionalities
- [ ] create Dockerfile