package dojo.store

import dojo.DojoComponent

trait Store[T, K] extends DojoComponent 

//                         queryEngine(query: String, options?: QueryOptions): QueryEngine<T>;
//                         queryEngine(query: AttributesMap, options?: QueryOptions): QueryEngine<T>;
//                         queryEngine(query: RegExp, options?: QueryOptions): QueryEngine<T>;
//                         queryEngine(query: (item: T) => boolean, options?: QueryOptions): QueryEngine<T>;
//                         add(object: T, directives?: PutDirectives<T, K>): K;
//                         get(id: K): T;
//                         getChildren<V>(parent: T, options?: QueryOptions): QueryResults<V>;
//                         getIdentity(object: T): K;
//                         getMetadata(object: T): { [metadata: String]: any; };
//                         put(object: T, directives?: PutDirectives<T, K>): K;
// 
//                         query(query: String, options?: QueryOptions): QueryResults<T>;
//                         query(query: AttributesMap, options?: QueryOptions): QueryResults<T>;
//                         query(query: (item: T) => boolean, options?: QueryOptions): QueryResults<T>;
// 
//                         remove(id: K): boolean;
// 
//                         transaction(): Transaction;
//                         Transaction: new () => Transaction;

trait StoreAsync[T, K] extends Store[T, K] {

//                         add(object: T, directives?: PutDirectives<T, K>): dojo.Promise<K>;
//                         get(id: K): dojo.Promise<T>;
//                         getChildren<V>(parent: T, options?: QueryOptions): dojo.Promise<QueryResults<V>>;
//                         getIdentity(object: T): dojo.Promise<K>;
//                         getMetadata(object: T): dojo.Promise<Object>;
//                         put(object: T, directives?: PutDirectives<T, K>): dojo.Promise<K>;
// 
//                         query(query: String, options?: QueryOptions): dojo.Promise<QueryResults<T>>;
//                         query(query: AttributesMap, options?: QueryOptions): dojo.Promise<QueryResults<T>>;
//                         query(query: (item: T) => boolean, options?: QueryOptions): dojo.Promise<QueryResults<T>>;
// 
//                         remove(id: K): boolean;
// 
//                         transaction(): TransactionAsync;
//                         Transaction: new () => TransactionAsync;
}

trait QueryEngine 
//                         (query: String, options?: QueryOptions): (data: T[]) => T[];
//                         (query: AttributesMap, options?: QueryOptions): (data: T[]) => T[];
//                         (query: RegExp, options?: QueryOptions): (data: T[]) => T[];
//                         (query: (item: T) => boolean, options?: QueryOptions): (data: T[]) => T[];
//
//                         matches?: (data: T) => boolean;


trait PutDirectives[K, T] {
    val id: K
    val before: T
    val parent: Object
    val overwrite: Boolean
}

trait QueryOptions {
      val start: Int
      val count: Int
      val sort: Array[SortInformation]
}

trait QueryResults[T] {
  val total: Int
}

//                         filter(callback: (item: T, index: number, array: T[]) => boolean, thisObject?: Object): QueryResults<T>;
//                         forEach(callback: (item: T, index: number, array: T[]) => void, thisObject?: Object): QueryResults<T>;
//                         map<V extends Object>(callback: (item: T, index: number, array: T[]) => V, thisObject?: Object): QueryResults<V>;
// 
//                         // Added by dojo/store/Observable
//                         observe? (listener: (object: T, removedFrom: number, insertedInto: number) => void, includeAllUpdates?: boolean): Dojo.CancellableHandle;

trait SortInformation {
        val attribute: String
        val descending: Boolean
}

trait Transaction {
        //def abort(callback: Option[Function], thisObject?: Object): Boolean
        //def commit(): Boolean
}

                trait TransactionAsync {
                        //abort(callback?: Function, thisObject?: Object): dojo.Promise<boolean>;
                        //commit(): dojo.Promise<boolean>;
                }

                // Create options

                trait CreateOptions extends DojoComponent {
                }

                trait Memory {
//                         interface CreateOptions<T extends Object> extends Dojo.Store.CreateOptions {
//                                 data?: T[];
//                         }
//                         class Store<T extends Object, K> extends Dojo.Store.Store<T, K> implements CreateOptions<T>
//                         {
//                                 constructor(options: CreateOptions<T>);
// 
//                                 idProperty: String;
//                                 data: T[];
//                                 index: Dojo.Dictionary<number>;
//                         }
                }
object Memory {
  val require = "dojo/store/Memory"
}

                trait DataStore {
                        trait CreateOptions {
                                var target: String;
                                var store: Object;         // Should be DojoDataStore, but needs to pull in dojo_data.ts and dojo.ts, so don't do it
                        }
                        //class Store[T, K] extends CreateOptions 
                        //class StoreAsync[T, K] extends CreateOptions {
                                //constructor(options: CreateOptions);

                        //        var target: String;
                        //        var store: Object;
                       // }
                }

                object DataStore {
  def require = "dojo/store/DataStore"
}

                trait JsonRest {
                        trait CreateOptions {
                                var target: String;
                                var accepts: String;
                                var ascendingPrefix: String;
                                var descendingPrefix: String;
                                var headers: Array[String]
                        }

                        object JsonRest { 
                          val require = "dojo/store/JsonRest"
                        }

//                         class Store[T, K] extends StoreAsync[T, K] with CreateOptions {
//                                 //constructor(options: CreateOptions);
// 
//                                 var target: String;
//                                 var accepts: String;
//                                 var ascendingPrefix: String;
//                                 var descendingPrefix: String;
//                                 var headers: Array[String]
//                         }
                }


trait Observable {
      //<T extends Object, K>(store: _Store<T, K>): _Store<T, K>;
}

object Observable {
  val require = "dojo/store/Observable"
}

trait Cache[T, K] {
}

object Cache {
  //val masterStore: Store<T, K>, cachingStore: Store<T, K>, options: { isLoaded?: (item: T) => boolean; }): _Store<T, K>;
  val require = "dojo/store/Cache"
}

